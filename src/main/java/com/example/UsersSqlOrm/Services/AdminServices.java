package com.example.UsersSqlOrm.Services;


import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.AppUserDto;
import com.example.UsersSqlOrm.Security.UserRepository;
import com.example.UsersSqlOrm.Security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminServices {

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public List<AppUser> getUsers(AppUser dto){
        return userService.findAll();
    }

    public Object createClient(AppUserDto appUserDto) {
        try{
            appUserDto.setPassword(passwordEncoder().encode(appUserDto.getPassword()));
            appUserDto.setCreated(new Date());
            appUserDto.setRole("CLIENT");
            AppUserDto.toDto(this.userRepository.save(AppUser.toEntity(appUserDto)));
            return appUserDto;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
