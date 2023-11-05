package com.example.UsersSqlOrm.Controllers.UserController;


import com.example.UsersSqlOrm.Security.AppUserDto;
import com.example.UsersSqlOrm.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/salon")
public class CreateUserController {


    @Autowired
    private UserService userService;


    @PostMapping(value="/register")
    public ResponseEntity<AppUserDto> createUser(@Valid  @RequestBody AppUserDto appUserDto){
        return new ResponseEntity<>(userService.save(appUserDto),HttpStatus.OK);
    }
}
