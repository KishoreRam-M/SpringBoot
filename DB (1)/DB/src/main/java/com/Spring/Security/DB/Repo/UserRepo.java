package com.Spring.Security.DB.Repo;

import com.Spring.Security.DB.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    // Now this should match the field name in the User entity
    User findByUsername(String username);  // "username" instead of "userName"

  //  User findByUserName(String username);
}
