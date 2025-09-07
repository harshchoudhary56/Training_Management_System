package com.ec_infosolutions.training_management_system.entities;

import com.ec_infosolutions.training_management_system.constants.BatchStatus;
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
@Table(name = "tbl_batch")
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Course course;

    @ManyToOne
    private User user;

    @ManyToOne
    private Location location;

    private BatchStatus status;

    private LocalDate startDate;
    private LocalDate endDate;
    private Integer maxCapacity;
}
