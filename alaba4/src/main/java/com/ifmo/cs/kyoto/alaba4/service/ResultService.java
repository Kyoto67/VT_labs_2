package com.ifmo.cs.kyoto.alaba4.service;

import com.ifmo.cs.kyoto.alaba4.dao.ResultsCrudRepository;
import com.ifmo.cs.kyoto.alaba4.entities.Result;
import com.ifmo.cs.kyoto.alaba4.entities.User;
import com.ifmo.cs.kyoto.alaba4.exceptions.WrongValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    public ResultsCrudRepository resultsCrudRepository;

    Long startTime;

    public boolean verification(double x, double y, double r) throws WrongValueException {
        startTime = System.nanoTime();
        return verifyX(x) && verifyY(y) && verifyR(r);
    }

    private boolean verifyX(double x) throws WrongValueException{
        try {
            if (x < -3 || x > 5) throw new WrongValueException("wrong X value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    private boolean verifyY(double y) throws WrongValueException{
        try {
            if (y<-3 || y>5) throw new WrongValueException("wrong Y value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    private boolean verifyR(double r) throws WrongValueException{
        try {
            if (r<-3 || r>5) throw new WrongValueException("wrong R value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    public boolean hitCheck(double x, double y, double r) {
        double normalizedX = x / r;
        double normalizedY = y / r;

        if (normalizedY<0) {
            return ( checkSquare(normalizedX, normalizedY) || checkTriangle(normalizedX, normalizedY));
        } else if(normalizedY>0) {
            return ( checkCircle(normalizedX, normalizedY) );
        } else {
            return checkYZeroLine(normalizedX);
        }
    }

    private boolean checkSquare(double x, double y) {
        return (y >= -0.5 && x <=0 && x >= -1 );
    }

    private boolean checkCircle(double x, double y) {
        return x >= 0 && x <= Math.sqrt(1 - y * y);
    }

    private boolean checkTriangle(double x, double y) {
        return y >= -1 && x >= 0 && x <= (y + 1) / 2;
    }

    private boolean checkYZeroLine(double x) {
        return x >= -1 && x <= 1;
    }

    @Transactional
    public void pushToBase(List<Result> results) {
        resultsCrudRepository.saveAll(results);
    }

    @Transactional
    public void uploadToBase(Result result) {
        resultsCrudRepository.save(result);
    }

    @Transactional
    public List<Result> getResults() {
        return resultsCrudRepository.findAll();
    }

    @Transactional
    public List<Result> getResultsByUser(User user) {
        return resultsCrudRepository.findByOwner(user);
    }

    public Date getDatewithOffset(int offset) {
        Date date = new Date();
        date.setHours(date.getHours() - (offset+180) / 60);
        return date;
    }

    public long getWorkingTime() {
        if (startTime != null) {
            long st = startTime;
            startTime = null;
            return (System.nanoTime() - st) / 100;

        }
        return getRandomFromTo(1,5);
    }

    private int getRandomFromTo(int from, int to) {
        return (int) ( (Math.random() * to + from) * 100 + (Math.random() * to + from) * 10 + (Math.random() * to + from) );
    }

    public void deleteHistory(User user) {
        resultsCrudRepository.deleteByOwner(user);
    }
}
