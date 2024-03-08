package com.example.tunehub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tunehub.entites.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	public User findByEmail(String email);
}
