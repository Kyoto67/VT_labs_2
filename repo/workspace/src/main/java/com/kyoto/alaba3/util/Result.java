package com.kyoto.alaba3.util;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name="weblab3")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HitsIdGenerator")
    @SequenceGenerator(name="weblab3", sequenceName="HIT_ID", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    long id;

    @Transient
    int sequenceNumber;

    @Max(5)
    @Min(-5)
    double x;

    @Max(5)
    @Min(-5)
    double y;

    @Max(5)
    @Min(2)
    double r;

    boolean match;

    String workingTime;

    @OneToOne (mappedBy = "result", cascade = CascadeType.ALL)
    MyEntityDate currentDateandTime;

    public Result() {

    }


    public Result(int sequenceNumber, double x, double y, double r, boolean match, String workingTime, MyEntityDate currentDateandTime) {
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

    public MyEntityDate getCurrentDateandTime() {
        return currentDateandTime;
    }
}
