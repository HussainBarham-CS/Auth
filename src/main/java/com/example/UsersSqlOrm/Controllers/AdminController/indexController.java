package com.example.UsersSqlOrm.Controllers.AdminController;

import com.example.UsersSqlOrm.CurrentUser;
import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/salon/admin")
public class indexController extends CurrentUser {

    @Autowired
    private UserService userService;


    @GetMapping(value="/users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<AppUser>> getUsers(){
        try{
            return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
