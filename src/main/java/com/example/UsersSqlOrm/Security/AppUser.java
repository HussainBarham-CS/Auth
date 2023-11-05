package com.example.UsersSqlOrm.Security;

import com.example.UsersSqlOrm.validation.ValidationRoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Entity(name="users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser implements UserDetails{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String email;
    @NotEmpty
    @NotNull
    @JsonIgnore
    private String password;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String phone;
    @NotEmpty
    @NotNull
    @ValidationRoleType
    private String role;
    @NotEmpty
    @NotNull
    private Date created;

    public static AppUser toEntity(AppUserDto dto){

        return AppUser.builder()

                .id(dto.getId())
                .created(dto.getCreated())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .name(dto.getName())
                .role(dto.getRole())
                .password(dto.getPassword())
                .build();
    }






    @Override
    @Bean
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Assuming roles are stored as a comma-separated string
        String roles = this.getRole(); // Replace this with your actual method to get roles

        if (roles != null && !roles.isEmpty()) {
            String[] roleArray = roles.split(",");

            for (String role : roleArray) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role.trim()));
            }
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }






}