package com.ifmo.cs.kyoto.lab4.entities;

import com.ifmo.cs.kyoto.lab4.entities.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@Table(name="weblab4")
public class Result {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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

    Date currentDateandTime;

    @ManyToOne (fetch = FetchType.LAZY)
    User owner;

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
