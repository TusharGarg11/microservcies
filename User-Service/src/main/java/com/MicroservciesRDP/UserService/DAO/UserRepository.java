package com.MicroservciesRDP.UserService.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MicroservciesRDP.UserService.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId(int userId);

}
