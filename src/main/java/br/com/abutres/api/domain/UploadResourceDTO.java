package br.com.abutres.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class UploadResourceDTO extends ResourceSupport {

    private final String filename;

    @JsonCreator
    public UploadResourceDTO(@JsonProperty("filename") String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
