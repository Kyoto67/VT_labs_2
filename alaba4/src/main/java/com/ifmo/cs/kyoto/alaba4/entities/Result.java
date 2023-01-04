package com.ifmo.cs.kyoto.alaba4.entities;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@Data
@Entity
@Table(name="weblab4")
public class  Result {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    long id;

    @Max(5)
    @Min(-5)
    double x;

    @Max(5)
    @Min(-5)
    double y;

    @Max(5)
    @Min(-5)
    double r;

    boolean match;

    long workingTime;

    Date currentDateandTime;

    @JoinColumn(name = "userid")
    @ManyToOne
    User owner;

    public Result() {

    }


    public Result(double x, double y, double r, boolean match, long workingTime, Date currentDateandTime, User owner) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.match = match;
        this.workingTime = workingTime;
        this.currentDateandTime = currentDateandTime;
        this.owner = owner;
    }

    @Override
    public String toString(){
        return "{\"x\":\"" + x + "\",\"y\":\"" + y +"\",\"r\":\"" + r +
                "\",\"match\":\"" + match + "\",\"workingTime\":\"" + workingTime + "\",\"currentDateandTime\":\"" + currentDateandTime + "\"}";
    }
}
