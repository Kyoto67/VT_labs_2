package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.User;

import java.util.List;

public interface UsersService {

    void pushToBase(List<User> users);
    List<User> getUsers();
    boolean findUserByName();
    boolean findUserByVKid();
    boolean checkPassword();
    boolean authableByVK();
    void updateVKid();
}
