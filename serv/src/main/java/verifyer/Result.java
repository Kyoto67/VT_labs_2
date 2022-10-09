package verifyer;

public class Result {

    private int sequenceNumber;
    private double x;
    private double y;
    private double r;
    private boolean match;
    private String workingTime;
    private String currentDateandTime;

    public Result(int sequenceNumber, double x, double y, double r, boolean match, String workingTime, String currentDateandTime) {
        this.sequenceNumber = sequenceNumber;
        this.x = x;
        this.y = y;
        this.r = r;
        this.match = match;
        this.workingTime = workingTime;
        this.currentDateandTime = currentDateandTime;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean isMatch() {
        return match;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public String getCurrentDateandTime() {
        return currentDateandTime;
    }

    @Override
    public String toString(){
        return "{\"sequenceNumber\":\"" + sequenceNumber + "\",\"x\":\"" + x + "\",\"y\":\"" + y +"\",\"r\":\"" + r + 
                "\",\"match\":\"" + match + "\",\"workingTime\":\"" + workingTime + "\",\"currentDateandTime\":\"" + currentDateandTime + "\"}";
    }
}
