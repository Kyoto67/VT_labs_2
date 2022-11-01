package verifyer;

import exception.WrongValueException;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class DataChecker {


    @EJB
    MetricRecorder metricRecorder;



    public DataChecker() {

    }

    public boolean verification(double x, double y, double r) throws WrongValueException {
        if (!verifyX(x)) throw new WrongValueException("x= " + x + " is invalid value");
        if (!verifyY(y)) throw new WrongValueException("y= " + y + " is invalid value");
        if (!verifyR(r)) throw new WrongValueException("r= " + r + " is invalid value");
        return true;
    }

    private boolean verifyX(double x) {
        final double xMin = -3.0;
        final double xMax = 5;
        return x >= xMin && x <= xMax;
    }

    private boolean verifyY(double y) {
        final double yMin = -5;
        final double yMax = 3;
        return y > yMin && y < yMax;
    }

    private boolean verifyR(double r) {
        final double rMin = 1;
        final double rMax = 3;
        return r >= rMin && r <= rMax;
    }

    private boolean hitCheck(double x, double y, double r) {
        double normalizedX = x / r;
        double normalizedY = y / r;

        if (normalizedY < 0) {
            return (normalizedX <= 0 && normalizedX >= triangleFunc(normalizedY)) || (normalizedX >= 0 && normalizedX <= 0.5 && normalizedY >= -1);
        } else if (normalizedY > 0) {
            return (normalizedX <= 0 && normalizedX >= circleFunc(normalizedY));
        } else { //normalizedY == 0
            return normalizedX >= -1 && normalizedX <= 0.5;
        }
    }

    public boolean hitCheckerHandle( double x, double y, double r){
        metricRecorder.shotInc();
        if ( hitCheck(x, y, r) ) {
            metricRecorder.hitInc();
            return true;
        }
        return false;
    }

    private double circleFunc(double y) {
        return (-1) * Math.sqrt(y * y * (-1) + 1);
    }

    private double triangleFunc(double y) {
        return (-1) * (y + 1);
    }
}
