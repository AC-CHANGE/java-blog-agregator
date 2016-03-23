package com.test.jba.repository;


import com.test.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository <User, Integer>{
}
