package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceRealization implements UsersService{

    @Autowired
    private UsersCrudRepository usersCrudRepository;

    @Override
    public void pushToBase(List<User> users) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public boolean findUserByName() {
        return false;
    }

    @Override
    public boolean findUserByVKid() {
        return false;
    }

    @Override
    public boolean checkPassword() {
        return false;
    }

    @Override
    public boolean authableByVK() {
        return false;
    }

    @Override
    public void updateVKid() {

    }
}
