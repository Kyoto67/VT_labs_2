package com.ifmo.cs.kyoto.alaba4.service;

import com.ifmo.cs.kyoto.alaba4.dto.HitDTO;
import com.ifmo.cs.kyoto.alaba4.dto.ResultDTO;
import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.util.ResultsPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResultPackageService {

    @Autowired
    ResultService resultService;

    public ResultsPair<Result, ResultDTO> service (User user, HitDTO hit) {
        boolean match = resultService.hitCheck(hit.getX(), hit.getY(), hit.getR());
        long workingTime = resultService.getWorkingTime();
        Date date = new Date();
        ResultDTO resultDTO = new ResultDTO(hit.getX(), hit.getY(), hit.getR(), match,workingTime, date);
        Result result = new Result(hit.getX(), hit.getY(), hit.getR(), match, workingTime, date, user);
        user.addResult(result);
        return new ResultsPair<>(result, resultDTO);
    }

}
