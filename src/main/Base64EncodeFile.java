package main;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;

public class Base64EncodeFile {
    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\ravi\\Desktop\\file1.txt";
       /* String encoded = encodeFileToBase64Binary(file);
        System.out.println(encoded);
        String decoded = decodeBase64String(encoded);
        System.out.println(decoded);*/
        System.out.println(decodeBase64File(file));

    }

    private static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return Base64.getEncoder().encodeToString(fileContent);
    }

    private static String decodeBase64String(String content) throws IOException {
        return new String(Base64.getDecoder().decode(content));
    }

    private static String decodeBase64File(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        return new String(Base64.getDecoder().decode(fileContent));
    }
}
