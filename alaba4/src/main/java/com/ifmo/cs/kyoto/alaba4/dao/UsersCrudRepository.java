package com.ifmo.cs.kyoto.alaba4.dao;

import com.ifmo.cs.kyoto.alaba4.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersCrudRepository extends JpaRepository<User, Long> {

    boolean existsUserByUsername(String username);
    User findByUsername(String username);

//    User findByUsername(String username) {
//        List<User> users = findAll();
//        for (User user : users) {
//            if (user.getUsername().equals(username)) return user;
//        }
//        return null;
//    }
}
