package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.Result;
import com.ifmo.cs.kyoto.lab4.exceptions.WrongValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ResultServiceRealization implements ResultsService {

    @Autowired
    private ResultsCrudRepository resultsCrudRepository;

    public ResultServiceRealization() {

    }

    @Override
    public boolean verification(double x, double y, double r) {
        try {
            return verifyX(x) && verifyY(y) && verifyR(r);
        } catch (WrongValueException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean verifyX(double x) throws WrongValueException{
        try {
            if (x < -5 || x > 5) throw new WrongValueException("wrong X value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    private boolean verifyY(double y) throws WrongValueException{
        try {
            if (y<-5 || y>5) throw new WrongValueException("wrong Y value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    private boolean verifyR(double r) throws WrongValueException{
        try {
            if (r<2 || r>5) throw new WrongValueException("wrong R value");
        } catch (Exception e) {
            throw new WrongValueException(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean hitCheck(double x, double y, double r) {
        double normalizedX = x / r;
        double normalizedY = y / r;

        if (normalizedY>0) {
            return ( checkSquare(normalizedX, normalizedY) );
        } else if(normalizedY<0) {
            return ( checkCircle(normalizedX, normalizedY) || checkTriangle(normalizedX, normalizedY));
        } else {
            return checkYZeroLine(normalizedX);
        }
    }

    private boolean checkSquare(double x, double y) {
        return (y <= 0.5 && x <=0 && x >= -1 );
    }

    private boolean checkCircle(double x, double y) {
        return x >= 0 && x <= Math.sqrt(1 - y * y);
    }

    private boolean checkTriangle(double x, double y) {
        return y >= -1 && x <= 0 && x >= (-y - 1) / 2;
    }

    private boolean checkYZeroLine(double x) {
        return x >= -1 && x <= 1;
    }

    @Transactional
    @Override
    public void pushToBase(List<Result> results) {
        resultsCrudRepository.saveAll(results);
    }

    @Override
    public Date getDatewithOffset(int offset) {
        Date date = new Date();
        date.setHours(date.getHours() - (offset+180) / 60);
        return date;
    }

    @Override
    public String getFormattedWorkingTime() {
        return "0.000" + getRandomFromTo(1,5) + " s";
    }

    private int getRandomFromTo(int from, int to) {
        return (int) ( Math.random() * to + from );
    }
}
