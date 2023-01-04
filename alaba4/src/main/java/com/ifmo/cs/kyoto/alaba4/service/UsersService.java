package com.ifmo.cs.kyoto.alaba4.service;

import com.ifmo.cs.kyoto.alaba4.dao.UsersCrudRepository;
import com.ifmo.cs.kyoto.alaba4.dto.UserDTO;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersCrudRepository usersCrudRepository;

    @Transactional
    public void pushToBase(List<User> users) {
        usersCrudRepository.saveAll(users);
    }

    @Transactional
    public List<User> getUsers() {
        return usersCrudRepository.findAll();
    }

    @Transactional
    public void uploadToBase( User user ) {
        usersCrudRepository.save( user );
    }

    public boolean findUserByName(String username) {
        return usersCrudRepository.existsUserByUsername(username);
    }

    public boolean findUserByVKid() {
        return false;
    }

    public boolean checkPassword() {
        return false;
    }

    public boolean authableByVK() {
        return false;
    }

    public void updateVKid() {

    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return usersCrudRepository.findByUsername(username);
    }
}
