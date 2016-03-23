package com.test.jba.repository;


import com.test.jba.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogRepository extends JpaRepository <Blog, Integer>{
}
