package com.example.UsersSqlOrm.Controllers.ClientController;


import com.example.UsersSqlOrm.Repository.ApointmentRepo;
import com.example.UsersSqlOrm.Services.ApointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/salon/appointment")
@PreAuthorize("hasAuthority('ROLE_CLIENT')")
public class AcceptAppointment {

    @Autowired
    private ApointmentServices apointmentServices;





    @PutMapping(value="/{appointId}/accept")
    public ResponseEntity<Object> accept(@PathVariable Integer appointId){
        return new ResponseEntity<>(apointmentServices.accept(appointId),HttpStatus.OK);
    }
}
