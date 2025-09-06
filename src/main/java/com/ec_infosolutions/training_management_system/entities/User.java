package com.ec_infosolutions.training_management_system.entities;

import com.ec_infosolutions.training_management_system.constants.Role;
import com.ec_infosolutions.training_management_system.constants.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

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

    private Role role;

    @ManyToOne
    private Location location;

    private UserStatus status;

    private String firstName;
    private String lastName;
    private String expertise;
    private Date enrollmentDate;
}
