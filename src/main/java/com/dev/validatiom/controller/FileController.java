package com.dev.validatiom.controller;


import com.dev.validatiom.model.FileDB;
import com.dev.validatiom.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {
    @Autowired
    public FileStorageService fileStorageService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file")MultipartFile file){
        try{
            FileDB savedFile = fileStorageService.store(file);
            return ResponseEntity.ok("File uploaded successful. ID" + savedFile.getId() + " " +savedFile.getFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not upload file: " + e.getMessage());
        }

    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id){
        Optional<FileDB> fileDB = fileStorageService.getFile(id);
        if(fileDB.isPresent()){
            FileDB file = fileDB.get();
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\""+ file.getFilename()+"\"")
                    .contentType(MediaType.parseMediaType(file.getFiletype()))
                    .body(file.getData());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }

    @GetMapping("/all")
    public List<FileDB> getAllFiles() {
        return fileStorageService.fileDBRepository.findAll();
    }

}
