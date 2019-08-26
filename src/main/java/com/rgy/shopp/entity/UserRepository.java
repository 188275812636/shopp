package com.rgy.shopp.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query("SELECT u FROM UserEntity AS u WHERE u.username = :username")
    UserEntity findByUsername(@Param("username") String username);
}
