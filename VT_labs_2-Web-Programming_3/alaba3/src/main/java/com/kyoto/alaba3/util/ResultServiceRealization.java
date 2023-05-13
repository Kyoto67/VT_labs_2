package com.kyoto.alaba3.util;

import com.kyoto.alaba3.exception.WrongValueException;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import java.util.Date;

@Singleton
@LocalBean
public class ResultServiceRealization implements ResultService {

    @EJB
    ResultDao dao;

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
        if (x<-5 || x>5) throw new WrongValueException("wrong X value");
        return true;
    }

    private boolean verifyY(double y) throws WrongValueException{
        if (y<-5 || y>5) throw new WrongValueException("wrong Y value");
        return true;
    }

    private boolean verifyR(double r) throws WrongValueException{
        if (r<2 || r>5) throw new WrongValueException("wrong R value");
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

    @Override
    public void pushToBase(Result result) {
        dao.uploadNewEntityToBase(result);
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
