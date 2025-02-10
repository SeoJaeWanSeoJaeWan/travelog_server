package com.travel.travelog_server.controller.upload;

import lombok.RequiredArgsConstructor;

import com.travel.travelog_server.service.UploadService;
import com.travel.travelog_server.util.FileUtils;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/upload")
public class UploadController {
    private final UploadService uploadService;

    @GetMapping("/file/{fileName}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable String fileName) {
        Pair<byte[], String> file = uploadService.loadFile(fileName);

        byte[] content = file.getLeft();
        String contentType = file.getRight();

        if(content == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, contentType).body(content);
    }

    @PostMapping("")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) {
        String fileName = FileUtils.generateFileName(Objects.requireNonNull(file.getOriginalFilename()));

        uploadService.saveFile(file, fileName);

        return ResponseEntity.ok(fileName);
    }
}
