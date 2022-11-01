package verifyer;

import lombok.Value;

@Value
public class Result { //todo Lombok + final

    int sequenceNumber;
    double x;
    double y;
    double r;
    boolean match;
    String workingTime;
    String currentDateandTime;

    @Override
    public String toString(){
        return "{\"sequenceNumber\":\"" + sequenceNumber + "\",\"x\":\"" + x + "\",\"y\":\"" + y +"\",\"r\":\"" + r + 
                "\",\"match\":\"" + match + "\",\"workingTime\":\"" + workingTime + "\",\"currentDateandTime\":\"" + currentDateandTime + "\"}";
    }
}
