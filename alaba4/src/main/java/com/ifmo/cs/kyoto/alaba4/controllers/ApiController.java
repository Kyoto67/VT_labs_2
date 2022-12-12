package com.ifmo.cs.kyoto.alaba4.controllers;

import com.ifmo.cs.kyoto.alaba4.dto.HitDTO;
import com.ifmo.cs.kyoto.alaba4.dto.ResultDTO;
import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.service.ResultPackageService;
import com.ifmo.cs.kyoto.alaba4.service.ResultService;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import com.ifmo.cs.kyoto.alaba4.util.ResultsPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    ResultService resultService;

    @Autowired
    UsersService usersService;

    @Autowired
    ResultPackageService resultPackageService;

    @PostMapping("hit")
    public @ResponseBody String hit(@RequestBody HitDTO hit, Principal principal ) {
        if (resultService.verification(hit.getX(), hit.getY(), hit.getR())) {
            User user = (User) usersService.loadUserByUsername(principal.getName());
            ResultsPair<Result, ResultDTO> resultsPair = resultPackageService.service(user, hit);
            resultService.uploadToBase(resultsPair.getResult());
            usersService.uploadToBase(user);
            return resultsPair.getResultDTO().toString();
        }
        return "Wrong data";
    }

    @GetMapping("bebra")
    public String bebrotka(){
        return "bebra";
    }
}
