package com.example.UsersSqlOrm.Repository;

import com.example.UsersSqlOrm.Models.Entitys.Apointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApointmentRepo extends JpaRepository<Apointment, Integer> {
}
