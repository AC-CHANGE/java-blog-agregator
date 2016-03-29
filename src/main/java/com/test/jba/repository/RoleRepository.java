package com.test.jba.repository;


import com.test.jba.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role,Integer>{
    Role findByName(String name);
}
