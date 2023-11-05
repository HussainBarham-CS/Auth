package com.example.UsersSqlOrm.Models.Entitys;
import com.example.UsersSqlOrm.Models.Dto.AppointDto;
import com.example.UsersSqlOrm.Security.AppUser;
import com.example.UsersSqlOrm.Security.AppUserDto;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Table(name="Apointments")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "clientId")
    private AppUser client;

    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;



    public static Apointment toEntity(AppointDto dto){

        return Apointment.builder()

                .id(dto.getId())
                .user(dto.getUser())
                .client(dto.getClient())
                .status(dto.getStatus())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
