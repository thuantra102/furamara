package com.example.furama.repository.user;

import com.example.furama.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByName(String name);
}
