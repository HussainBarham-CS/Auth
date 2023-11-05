package com.example.UsersSqlOrm.Controllers.AdminController;


import com.example.UsersSqlOrm.Security.AppUserDto;
import com.example.UsersSqlOrm.Services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/salon/admin")
public class createClient {


    @Autowired
    private AdminServices adminServices;


    @PostMapping("/addClient")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Object> createClient(@RequestBody @Valid AppUserDto appUserDto){
        return new ResponseEntity<>(adminServices.createClient(appUserDto), HttpStatus.CREATED);
    }
}
