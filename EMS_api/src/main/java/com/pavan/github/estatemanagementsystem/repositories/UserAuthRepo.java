package com.pavan.github.estatemanagementsystem.repositories;

import com.pavan.github.estatemanagementsystem.entities.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepo extends JpaRepository<UserAuth, String> {

    Optional<UserAuth> findByUsername(String username);
}
