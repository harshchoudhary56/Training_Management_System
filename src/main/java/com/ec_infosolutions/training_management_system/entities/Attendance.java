package com.ec_infosolutions.training_management_system.entities;

import com.ec_infosolutions.training_management_system.constants.AttendanceStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tbl_attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Session session;

    @ManyToOne
    private User user;

    private LocalDate markedAt;
    private AttendanceStatus status;
}
