package com.example.UsersSqlOrm.Models.Dto;

import com.example.UsersSqlOrm.Models.Entitys.Apointment;
import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.AppUserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointDto {
    @NotNull
    @NotEmpty
    private Integer id;
    @NotNull
    @NotEmpty
    private AppUser user;
    @NotNull
    @NotEmpty
    private AppUser client;
    @NotNull
    @NotEmpty
    private String status;
    @NotNull
    @NotEmpty
    private Date createdAt;
    @NotNull
    @NotEmpty
    private Date updatedAt;

    public static AppointDto toDto(Apointment entity){
        return AppointDto.builder()

                .id(entity.getId())
                .user(entity.getUser())
                .client(entity.getClient())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

}
