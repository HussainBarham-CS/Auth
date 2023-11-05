package com.example.UsersSqlOrm.Security;

import com.example.UsersSqlOrm.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = (userRepository.findByEmail(username));

        if (user == null) {
            throw new NotFoundException("User not found");
        }


       return user;


    }

    public AppUserDto save(AppUserDto user) {
        try{
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            user.setCreated(new Date());
            user.setRole("USER");
            AppUserDto.toDto(this.userRepository.save(AppUser.toEntity(user)));
            return user;
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    public AppUserDto findByUser(Integer id) {
        Optional<AppUser> user = this.userRepository.findById(id);
        if(user.isPresent()) {
            return AppUserDto.toDto(user.get());
        }
        else
            return null;
    }

}