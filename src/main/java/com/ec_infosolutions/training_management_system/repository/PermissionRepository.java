package com.ec_infosolutions.training_management_system.repository;

import com.ec_infosolutions.training_management_system.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
