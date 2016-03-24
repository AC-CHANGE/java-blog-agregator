package com.test.jba.service;

import com.test.jba.entity.Blog;
import com.test.jba.entity.Item;
import com.test.jba.entity.User;
import com.test.jba.repository.BlogRepository;
import com.test.jba.repository.ItemRepository;
import com.test.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findAOne(int id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public User findAOneWithBlogs(int id) {
        User user = findAOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog : blogs) {
            List<Item> items = itemRepository.findByBlog(blog);
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }
}
