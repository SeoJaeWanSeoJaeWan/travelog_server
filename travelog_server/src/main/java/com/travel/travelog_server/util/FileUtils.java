package com.travel.travelog_server.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    @Setter
    @Getter
    private static String filePath;

    public static String[] getFileNameAndExtension(String originFileName) {
        int lastIndexOfDot = originFileName.lastIndexOf(".");
        String name = originFileName.substring(0, lastIndexOfDot);
        String extension = originFileName.substring(lastIndexOfDot);

        return new String[]{name, extension};
    }

    public static String generateFileName(String originFileName) {
        String[] nameAndExtension = getFileNameAndExtension(originFileName);
        String name = nameAndExtension[0];
        String extension = nameAndExtension[1];
        int fileNumber = 1;

        String fileSequence = "";

        while(new java.io.File(filePath + name + fileSequence + extension).exists()) {
            fileSequence= "(" + fileNumber + ")";
            fileNumber++;
        }

        return name + fileSequence + extension;
    }

    public static Pair<byte[], String> readFileContent(String fileName) {
        if(filePath == null || filePath.isEmpty()) {
            throw new IllegalStateException("File path is not set");
        }

        Path path = Paths.get(filePath + fileName).normalize();

        try {
            byte[] file = Files.readAllBytes(path);
            String contentType = Files.probeContentType(path);

            return Pair.of(file, contentType);
        } catch(IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }

    public static boolean validImageExtension(String originFileName) {
        String[] nameAndExtension = getFileNameAndExtension(originFileName);
        String extension = nameAndExtension[1].toLowerCase();

        return extension.equals(".jpg") || extension.equals(".jpeg") || extension.equals(".png") || extension.equals(".gif");
    }
}
