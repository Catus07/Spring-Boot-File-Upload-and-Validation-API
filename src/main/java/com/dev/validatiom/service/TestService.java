package com.dev.validatiom.service;

import com.dev.validatiom.dto.UserDto;
import com.dev.validatiom.model.UserModel;
import com.dev.validatiom.repo.ValidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    public ValidRepo validRepo;
    public int additional(int first, int second){
        int answer = first + second;
        return answer;
    }
    public void createUser(UserDto userDto){
        UserModel user = new UserModel();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstname(userDto.getFirstname());

        validRepo.save(user);

    }
}
