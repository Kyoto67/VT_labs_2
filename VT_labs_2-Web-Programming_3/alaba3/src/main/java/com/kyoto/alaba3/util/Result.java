package com.kyoto.alaba3.util;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@Table(name="mspi_lab4")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HitsIdGenerator")
    @SequenceGenerator(name="mspi_lab4", sequenceName="HIT_ID", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    long id;

    @Transient
    int sequenceNumber;

    @Column
    @Max(5)
    @Min(-5)
    double x;

    @Column
    @Max(5)
    @Min(-5)
    double y;

    @Column
    @Max(5)
    @Min(2)
    double r;

    @Column
    boolean match;

    @Column
    String workingTime;

    @Column
    Date currentDateandTime;

    public Result() {

    }


    public Result(int sequenceNumber, double x, double y, double r, boolean match, String workingTime, Date currentDateandTime) {
        this.sequenceNumber = sequenceNumber;
        this.x = x;
        this.y = y;
        this.r = r;
        this.match = match;
        this.workingTime = workingTime;
        this.currentDateandTime = currentDateandTime;
    }

    @Override
    public String toString(){
        return "{\"sequenceNumber\":\"" + sequenceNumber + "\",\"x\":\"" + x + "\",\"y\":\"" + y +"\",\"r\":\"" + r + 
                "\",\"match\":\"" + match + "\",\"workingTime\":\"" + workingTime + "\",\"currentDateandTime\":\"" + currentDateandTime + "\"}";
    }
}
