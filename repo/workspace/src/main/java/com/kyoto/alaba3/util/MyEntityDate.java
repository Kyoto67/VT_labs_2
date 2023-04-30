package com.kyoto.alaba3.util;

import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Setter
@Table(name="weblab3date")
@Entity
public class MyEntityDate extends Date {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DateIdGenerator")
    @SequenceGenerator(name="weblab3date", sequenceName="Date_ID", allocationSize = 1)
    @Column(name = "id", updatable = false, nullable = false)
    long id;

    private String currDateandTime;

    @OneToOne (fetch = FetchType.LAZY)
    private Result result;

    public MyEntityDate() {
        super();
        currDateandTime = this.toString();
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
