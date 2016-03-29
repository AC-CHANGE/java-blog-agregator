package com.test.jba.entity;

import javax.persistence.*;
import javax.print.DocFlavor;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    private String password;
    private  boolean enabled;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY )
    private List<Blog> blogs;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
