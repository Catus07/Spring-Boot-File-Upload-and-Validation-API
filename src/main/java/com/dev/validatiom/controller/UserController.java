package com.dev.validatiom.controller;

import com.dev.validatiom.dto.UserDto;
import com.dev.validatiom.model.UserModel;
import com.dev.validatiom.repo.ValidRepo;
import com.dev.validatiom.service.TestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated // enable method parameter validation
public class UserController {

    @Autowired
    public TestService testService;

    @Autowired
    public ValidRepo validRepo;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Custom-Header", "Test")
                .body("Hello");
        // Full control over status, headers, and body.
        //is a class that represents the entire HTTP response,
        // not just the body. It gives you full control over:
    }


    @PostMapping("/users")
    public UserModel createUser(@RequestBody UserModel userModel){
        return validRepo.save(userModel);
    }

    @PostMapping("/postUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok("user created");
    }

    @GetMapping("/home")
    public String home(){
        return "Rest Api ";
    }
    @GetMapping("/add")
    public int get(){
        return testService.additional(2,4);
    }
}
