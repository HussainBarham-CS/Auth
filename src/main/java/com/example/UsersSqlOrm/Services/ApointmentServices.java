package com.example.UsersSqlOrm.Services;

import com.example.UsersSqlOrm.CurrentUser;
import com.example.UsersSqlOrm.Models.Dto.AppointDto;
import com.example.UsersSqlOrm.Models.Entitys.Apointment;
import com.example.UsersSqlOrm.Repository.ApointmentRepo;
import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.AppUserDto;
import com.example.UsersSqlOrm.Security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
public class ApointmentServices extends CurrentUser {

    @Autowired
    private ApointmentRepo apointmentRepo;

    @Autowired
    private UserRepository userRepository;
    public Object makeAppointment(Integer clientId) {
        try{
            Optional<AppUser> user = userRepository.findById(clientId);
            if(user.isPresent()){
                AppointDto temp = AppointDto.builder()
                        .status("pending")
                        .createdAt(new Date())
                        .updatedAt(new Date())
                        .client(user.get())
                        .user(getCurrentUser())
                        .build();

                AppointDto.toDto(this.apointmentRepo.save(Apointment.toEntity(temp)));
                return temp;
            }
            else{
                throw new RuntimeException();
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public Object accept(Integer appointId) {
        Optional<Apointment> temp =  apointmentRepo.findById(appointId);
        if(temp.isPresent()){
            temp.get().setStatus("accepted");
            temp.get().setUpdatedAt(new Date());
            apointmentRepo.save(temp.get());
            return temp;

        }
        throw new RuntimeException("error");
    }

    public Object reject(Integer appointId) {
        Optional<Apointment> temp =  apointmentRepo.findById(appointId);
        if(temp.isPresent()){
            temp.get().setStatus("rejected");
            temp.get().setUpdatedAt(new Date());
            apointmentRepo.save(temp.get());
            return temp;

        }
        throw new RuntimeException("error");
    }



}
