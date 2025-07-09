package com.dev.validatiom.service;

import com.dev.validatiom.model.FileDB;
import com.dev.validatiom.repo.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageService {
    @Autowired
    public FileDBRepository fileDBRepository;

    public FileDB store(MultipartFile file)throws IOException{
        FileDB fileDB = new FileDB();
        fileDB.setFilename(file.getOriginalFilename());
        fileDB.setFiletype(file.getContentType());
        fileDB.setData(file.getBytes());
        return fileDBRepository.save(fileDB);
    }
    public Optional<FileDB> getFile(long id){
        return fileDBRepository.findById(id);
    }
}