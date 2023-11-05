package com.example.UsersSqlOrm.Util;
import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.AppUserDto;
import com.example.UsersSqlOrm.Security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        if (userService.findAll().isEmpty()) {
            logger.info("No Users accounts found. Creating some users");


            AppUserDto Admin = AppUserDto.builder()
                    .created(new Date())
                    .email("admin@gmail.com")
                    .phone("0592101558")
                    .name("admin")
                    .role("ADMIN")
                    .password("admin")
                    .build();


            AppUserDto user = AppUserDto.builder()
                    .created(new Date())
                    .email("ahmad@gmail.com")
                    .phone("0592101552")
                    .name("ahmad")
                    .role("USER")
                    .password("user")
                    .build();
            userService.save(Admin);
            userService.save(user);


        }
    }
}