package com.example.UsersSqlOrm.Controllers.UserController;


import com.example.UsersSqlOrm.Models.Dto.AppointDto;
import com.example.UsersSqlOrm.Services.ApointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/salon/appointment")
public class MakeAppointmentRequest {

    @Autowired
    private ApointmentServices apointmentServices;


    @PostMapping(value="/request")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Object> makeAppointment(@RequestBody Integer clientId){
        try{
            System.out.println("hiiiiiiii");
            return new ResponseEntity(apointmentServices.makeAppointment(clientId),HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
