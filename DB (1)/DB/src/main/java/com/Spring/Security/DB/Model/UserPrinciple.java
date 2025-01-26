package com.Spring.Security.DB.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserPrinciple implements UserDetails {

    private User user;  // Remove @Autowired

    // Constructor
    public UserPrinciple(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming "USER" role for simplicity, could be dynamic depending on the user roles
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();  // Change to getUserName() if your User class has that field
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Adjust logic based on your requirements
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Adjust logic based on your requirements
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Adjust logic based on your requirements
    }

    @Override
    public boolean isEnabled() {
        return true; // Adjust logic based on your requirements
    }
}
