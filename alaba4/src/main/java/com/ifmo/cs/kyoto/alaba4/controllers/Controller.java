package com.ifmo.cs.kyoto.alaba4.controllers;

import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.service.ResultService;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("bebra")
public class Controller {

    @Autowired
    private ResultService resultService;

    @Autowired
    private UsersService usersService;

    List<Result> resultList = new ArrayList<>();
    List<User> userList = new ArrayList<>();


    @GetMapping
    public @ResponseBody String list(){

//        User user1 = new User("kyoto", "admin");
//        User user2 = new User("234", "432");
//        User user3 = new User("345", "534");
//        Result result1 = new Result(1, 1, 1, 1, true, "0s", new Date(), user1);
//        Result result2 = new Result(2, 2, 2, 2, true, "0s", new Date(), user2);
//        Result result3 = new Result(3, 3, 3, 3, true, "0s", new Date(), user1);
//        resultList.add(result1);
//        resultList.add(result2);
//        resultList.add(result3);
//        userList.add(user1);
//        userList.add(user2);
//        userList.add(user3);
//        usersService.pushToBase(userList);
//        resultService.pushToBase(resultList);
        return "ok";


//        userList = usersService.getUsers();
//        resultList = resultService.getResults();
//
//        final String[] out = {"users:\n"};
//
//        userList.forEach( (u) -> out[0] += "\t" + u.toString() + "\n");
//
//        out[0] += "results:\n";
//
//        resultList.forEach( (r) -> out[0] += "\t" + r.toString() + "\n");
//
//        return out[0];
    }



}
