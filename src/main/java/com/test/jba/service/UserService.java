package com.test.jba.service;

import com.test.jba.entity.Blog;
import com.test.jba.entity.Item;
import com.test.jba.entity.Role;
import com.test.jba.entity.User;
import com.test.jba.repository.BlogRepository;
import com.test.jba.repository.ItemRepository;
import com.test.jba.repository.RoleRepository;
import com.test.jba.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

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
            List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0,10, Sort.Direction.DESC,"publishedDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(user);
    }

    public User findAOneWithBlogs(String name) {
        User user = userRepository.findByName(name);
        return findAOneWithBlogs(user.getId());
    }
}
