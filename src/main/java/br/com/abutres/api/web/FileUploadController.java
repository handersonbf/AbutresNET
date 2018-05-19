package br.com.abutres.api.web;

import br.com.abutres.api.domain.UploadResourceDTO;
import br.com.abutres.api.util.HGUnique;
import br.com.abutres.api.util.OSValidator;
import br.com.abutres.api.validation.ServerErrorDTO;
import org.springframework.http.*;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("api/storage")
@CrossOrigin(origins = "*")
public class FileUploadController {

    private static final String ROOT = OSValidator.isUnix() ? "/opt" : "C:\\";
    private static final String PATH = "abutres/upload/profile";
    private static final String ROOT_PATH = String.format("%s/%s", ROOT, PATH);

    @PostMapping("/upload")
    @ResponseBody
    public HttpEntity<?> upload(@RequestParam("file") @NotNull(message = "O arquivo é obrigatório.") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>(new ServerErrorDTO(HttpStatus.PRECONDITION_FAILED.toString(),
                    String.format("O arquivo não existe %s não existe.",
                            file.getOriginalFilename()), null),
                    HttpStatus.PRECONDITION_FAILED);
        }

        if (!file.getOriginalFilename().matches("([^\\s]+(\\.(?i)(jpg|png))$)")) {
            return new ResponseEntity<>(new ServerErrorDTO(HttpStatus.PRECONDITION_FAILED.toString(),
                    String.format("A extensão informada é invalida."), null),
                    HttpStatus.PRECONDITION_FAILED);
        }

        try {
            return new ResponseEntity(new UploadResourceDTO(this.profileDirectory().save(file)), HttpStatus.OK);
        } catch (IOException | NoSuchAlgorithmException e) {
            System.err.println(e);
            return new ResponseEntity("Error uploaded", new HttpHeaders(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/image/{filemane}", method = RequestMethod.GET,
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public ResponseEntity<byte[]> getImage(
            @PathVariable("filemane") @NotNull(message = "O nome do arquivo é obrigatório.") String filename
    ) throws IOException {
        final File iFile = new File(ROOT_PATH + "/" + filename);
        final long resourceLength = iFile.length();
        final long lastModified = iFile.lastModified();

        InputStream image = new FileInputStream(iFile);
        byte[] media = StreamUtils.copyToByteArray(image);

        return ResponseEntity.ok()
                .header("Content-Disposition", "inline; filename=" + filename)
                .contentLength(resourceLength)
                .lastModified(lastModified)
                .body(media);
    }

    private String save(MultipartFile file) throws IOException, NoSuchAlgorithmException {
        String filename = HGUnique.image(file.getOriginalFilename());
        Path path = Paths.get(String.format("%s/%s", ROOT_PATH, filename));
        Files.write(path, file.getBytes());
        return filename;
    }

    /**
     * Criar diretoria caso não exista
     *
     * @return se o diretorio raiz não criado com sucesso retorna false
     * @throws IOException
     */
    private FileUploadController profileDirectory() throws IOException {
        File sourcePath = new File(ROOT_PATH);
        if (!sourcePath.exists()) {
            sourcePath.mkdirs();
        }
        return this;
    }
}
