package com.dev.validatiom.repo;

import com.dev.validatiom.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidRepo extends JpaRepository<UserModel, Long> {
}
