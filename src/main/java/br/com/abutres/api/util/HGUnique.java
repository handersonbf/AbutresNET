/**
 * Hash Generator cria nomes unicos pra imagens
 *
 * @author deoprog@gmail.com
 * @created 19/05/2018
 */

package br.com.abutres.api.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HGUnique {

    public static String image(String fileOriginalName) throws NoSuchAlgorithmException {
        String dateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss").format(new Date()) + "-" + System.nanoTime();
        MessageDigest md = MessageDigest.getInstance("MD5");
        StringBuilder hash = new StringBuilder();

        byte[] md5 = fileOriginalName.isEmpty()
                ? md.digest(dateFormat.getBytes())
                : md.digest(fileOriginalName.getBytes());

        for (byte b : md5) {
            hash.append(Integer.toHexString(((b & 0xFF) | 0x100)).substring(1, 3));
        }

        hash = hash.length() > 15 ? hash.delete(15, hash.length()) : hash;

        return hash.toString().toUpperCase() + "-" + dateFormat + "." + fileOriginalName
                .substring(fileOriginalName.lastIndexOf(".") + 1);
    }
}
