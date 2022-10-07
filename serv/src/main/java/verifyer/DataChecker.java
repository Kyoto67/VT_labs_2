package verifyer;

import exception.WrongValueException;

public class DataChecker {

    private double x;
    private double y;
    private double r;
    private double xMin = -3.0;
    private double xMax = 5;
    private double yMin = -5;
    private double yMax = 3;
    private double rMin = 1;
    private double rMax = 3;

    public DataChecker(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public boolean verification() throws WrongValueException {
        if (!verifyX()) throw new WrongValueException("x= " + x + " is invalid value");
        if (!verifyY()) throw new WrongValueException("y= " + y + " is invalid value");
        if (!verifyR()) throw new WrongValueException("r= " + r + " is invalid value");
        return true;
    }

    private boolean verifyX() {
        return x >= xMin && x <= xMax;
    }

    private boolean verifyY() {
        return y > yMin && y < yMax;
    }

    private boolean verifyR() {
        return r >= rMin && r <= rMax;
    }

    public boolean hitCheck() {
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

    private double circleFunc(double y) {
        return (-1) * Math.sqrt(y * y * (-1) + 1);
    }

    private double triangleFunc(double y) {
        return (-1) * (y + 1);
    }
}
