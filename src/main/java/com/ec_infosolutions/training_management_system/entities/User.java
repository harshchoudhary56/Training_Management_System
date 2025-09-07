package com.ec_infosolutions.training_management_system.entities;

import com.ec_infosolutions.training_management_system.constants.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @ManyToOne
    private Location location;

    @OneToOne
    private Role role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String firstName;
    private String lastName;
    private String expertise;
    private LocalDate enrollmentDate;
}
