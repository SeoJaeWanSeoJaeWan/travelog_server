package com.travel.travelog_server.service;

import com.travel.travelog_server.util.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadService {
    public Pair<byte[], String> loadFile(String fileName) {
        return FileUtils.readFileContent(fileName);
    }

    public void saveFile(MultipartFile file, String fileName) {
        File targetFile = new File(FileUtils.getFilePath() + fileName);

        try {
            if(!FileUtils.validImageExtension(fileName)) {
                throw new FileUploadException("이미지 파일만 업로드할 수 있습니다.");
            }

            file.transferTo(targetFile);
        } catch(IOException e) {
            throw new RuntimeException("파일을 저장하지 못했습니다.", e);
        }
    }
}
