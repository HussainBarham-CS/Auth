package com.example.UsersSqlOrm.Security;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    @JsonIgnore
    private Integer id;
    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private String password;
    @NotEmpty
    @NotNull
    private String phone;
    @NotEmpty
    @NotNull
    private String name;
    @JsonIgnore
    private String role;
    @NotEmpty
    @NotNull
    private Date created;


    public static AppUserDto toDto(AppUser entity){
        return AppUserDto.builder()

                .id(entity.getId())
                .created(entity.getCreated())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .name(entity.getName())
                .role(entity.getRole())
                .build();
    }
}
