package com.Spring.Security.DB.Controller;

import com.Spring.Security.DB.Model.User;
import com.Spring.Security.DB.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/")
    public List<User> toGetUser()
    {
        return  service. getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> toGetUser(@PathVariable  int id )
    {
        return  service.getUserById(id);
    }

}
