package com.test.jba.repository;


import com.test.jba.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository <Item, Integer>{


}
