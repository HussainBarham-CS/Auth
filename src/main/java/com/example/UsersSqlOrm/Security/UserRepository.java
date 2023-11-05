package com.example.UsersSqlOrm.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByEmail(String email);
    //Optional<AppUser> findByEmail(String email);
}