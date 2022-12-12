package com.ifmo.cs.kyoto.alaba4.controllers;

import com.ifmo.cs.kyoto.alaba4.dto.UserDTO;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.jwt.JWT;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    UsersService usersService;

    @Autowired
    JWT jwt;

    @PostMapping("login")
    public @ResponseBody String auth(@RequestBody UserDTO user) {
        if (usersService.findUserByName(user.getUsername())) {
            if (usersService.loadUserByUsername(user.getUsername()).getPassword().equals(user.getPassword())) return jwt.generateToken(user.getUsername());
//            throw new WrongPasswordException();
            return "wrong password";
        }
        return "user not found";
    }

    @PostMapping("register")
    public @ResponseBody String reg(@RequestBody UserDTO user) {
        if (usersService.findUserByName(user.getUsername())) {
            return "user already exists";
        }
        usersService.uploadToBase(new User(user.getUsername(), user.getPassword()));
        return jwt.generateToken(user.getUsername());
    }
}
