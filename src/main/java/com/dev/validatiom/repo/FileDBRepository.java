package com.dev.validatiom.repo;

import com.dev.validatiom.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDBRepository extends JpaRepository<FileDB,Long> {

}
