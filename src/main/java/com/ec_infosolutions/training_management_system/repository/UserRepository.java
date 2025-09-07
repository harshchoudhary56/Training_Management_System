package com.ec_infosolutions.training_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ec_infosolutions.training_management_system.entities.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

    public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    @Query("SELECT u from User u Where u.status =  com.ec_infosolutions.training_management_system.constants.UserStatus.ACTIVE")
    List<User> findAllActiveUsers();

    @Query("SELECT u FROM User u WHERE u.id = :id AND u.status = com.ec_infosolutions.training_management_system.constants.UserStatus.ACTIVE")
    Optional<User> findById(Integer id);
}
