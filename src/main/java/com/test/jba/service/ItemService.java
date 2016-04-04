package com.test.jba.service;

import com.test.jba.entity.Item;
import com.test.jba.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getItems(){
        return itemRepository.findAll(new PageRequest(0,20, Sort.Direction.DESC, "publishedDate")).getContent();
    }
}
