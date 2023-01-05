package com.ifmo.cs.kyoto.alaba4.controllers;

import com.ifmo.cs.kyoto.alaba4.dto.HitDTO;
import com.ifmo.cs.kyoto.alaba4.dto.ResultDTO;
import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.exceptions.WrongValueException;
import com.ifmo.cs.kyoto.alaba4.service.ResultPackageService;
import com.ifmo.cs.kyoto.alaba4.service.ResultService;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import com.ifmo.cs.kyoto.alaba4.util.ResultsPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

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
    public @ResponseBody ResponseEntity hit(@RequestBody HitDTO hit, Principal principal ) throws WrongValueException {
            if (resultService.verification(hit.getX(), hit.getY(), hit.getR())) {
                User user = usersService.loadUserByUsername(principal.getName());
                ResultsPair<Result, ResultDTO> resultsPair = resultPackageService.service(user, hit);
                resultService.uploadToBase(resultsPair.getResult());
                usersService.uploadToBase(user);
                System.out.println(resultsPair.getResultDTO().toString());
                return new ResponseEntity<>(resultsPair.getResultDTO().toString(), HttpStatus.OK) ;
            }
        throw new WrongValueException("Wrong data");
    }

    @GetMapping("mydata")
    public @ResponseBody String getData(Principal principal) {
        User user = usersService.loadUserByUsername(principal.getName());
        List<Result> results = resultService.getResultsByUser(user);
        if (results == null) return null;
        return resultsToJSON(results);
    }

    private String resultsToJSON(List<Result> results) {
        String[] output = {"["};
        results.forEach( (obj) -> output[0]+= obj.toString() + ", \n");
        output[0] = output[0].substring( 0, output[0].length() - 3);
        output[0] += "]";
        return output[0];
    }
}
