package com.test.jba.repository;


import com.test.jba.entity.Blog;
import com.test.jba.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BlogRepository extends JpaRepository <Blog, Integer>{

    List<Blog> findByUser(User user);
}
