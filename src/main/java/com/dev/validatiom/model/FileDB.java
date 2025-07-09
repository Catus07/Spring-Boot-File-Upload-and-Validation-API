package com.dev.validatiom.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "files")
@Data
public class FileDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "File_name")
    public String filename;

    @Column(name = "File_path")
    public String filetype;

    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;


}