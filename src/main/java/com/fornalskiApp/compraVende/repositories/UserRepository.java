package com.fornalskiApp.compraVende.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fornalskiApp.compraVende.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
