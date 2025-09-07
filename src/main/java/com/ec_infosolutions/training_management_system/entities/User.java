package com.ec_infosolutions.training_management_system.entities;

import com.ec_infosolutions.training_management_system.constants.Role;
import com.ec_infosolutions.training_management_system.constants.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    private Location location;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String firstName;
    private String lastName;
    private String expertise;
    private LocalDate enrollmentDate;
}
