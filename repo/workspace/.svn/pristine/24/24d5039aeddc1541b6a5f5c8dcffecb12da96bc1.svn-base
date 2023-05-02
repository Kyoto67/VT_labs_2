package com.kyoto.alaba3.tests;

import com.kyoto.alaba3.exception.WrongValueException;
import com.kyoto.alaba3.util.MyEntityDate;
import com.kyoto.alaba3.util.Result;
import com.kyoto.alaba3.util.ResultServiceRealization;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ResultServiceRealizationTest {

    private ResultServiceRealization service;
    private double[] verificationCoords1;
    private double[] verificationCoords2;
    private double[] verificationCoords3;
    private double[] verificationCoords4;
    private double[] verificationCoords5;
    private double[] hitCheckCoords1;
    private double[] hitCheckCoords2;
    private double[] hitCheckCoords3;
    private double[] hitCheckCoords4;
    private double[] hitCheckCoords5;
    private double[] hitCheckCoords6;
    private int minutesOffset;
    private int hoursOffset;
    private String regexp;

    @Before
    public void setUp() throws FileNotFoundException {
        File loc = new File("/home/kyoto/git/repo/workspace/src/main/java/com/kyoto/alaba3/tests/localization.loc");
        Scanner scanner = new Scanner(loc);
        regexp = scanner.nextLine();
        double[] arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        verificationCoords1 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        verificationCoords2 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        verificationCoords3 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        verificationCoords4 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        verificationCoords5 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords1 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords2 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords3 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords4 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords5 = arrDouble;
        arrDouble = new double[3];
        arrDouble[0] = scanner.nextDouble();
        arrDouble[1] = scanner.nextDouble();
        arrDouble[2] = scanner.nextDouble();
        hitCheckCoords6 = arrDouble;
        minutesOffset = scanner.nextInt();
        hoursOffset = scanner.nextInt();
        service = new ResultServiceRealization();
    }

    @Test
    public void testVerification() throws WrongValueException {
        assertTrue(service.verification(verificationCoords1[0], verificationCoords1[1], verificationCoords1[2]));
        assertFalse(service.verification(verificationCoords2[0], verificationCoords2[1], verificationCoords2[2]));
        assertFalse(service.verification(verificationCoords3[0], verificationCoords3[1], verificationCoords3[2]));
        assertFalse(service.verification(verificationCoords4[0], verificationCoords4[1], verificationCoords4[2]));
        assertFalse(service.verification(verificationCoords5[0], verificationCoords5[1], verificationCoords5[2]));
    }

    @Test
    public void testHitCheck() {
        assertTrue(service.hitCheck(hitCheckCoords1[0], hitCheckCoords1[1], hitCheckCoords1[2]));
        assertFalse(service.hitCheck(hitCheckCoords2[0], hitCheckCoords2[1], hitCheckCoords2[2]));
        assertFalse(service.hitCheck(hitCheckCoords3[0], hitCheckCoords3[1], hitCheckCoords3[2]));
        assertFalse(service.hitCheck(hitCheckCoords4[0], hitCheckCoords4[1], hitCheckCoords4[2]));
        assertFalse(service.hitCheck(hitCheckCoords5[0], hitCheckCoords5[1], hitCheckCoords5[2]));
        assertFalse(service.hitCheck(hitCheckCoords6[0], hitCheckCoords6[1], hitCheckCoords6[2]));
    }

//    @Test
//    public void testPushToBase() {
//        Result result = new Result();
//        service.pushToBase(result);
//        // check if result was added to the database
//        // assert something
//    }

    @Test
    public void testGetDatewithOffset() {
        MyEntityDate date = service.getDatewithOffset(minutesOffset);
        assertEquals(date.getHours(), new Date().getHours() + hoursOffset);
    }

    @Test
    public void testGetFormattedWorkingTime() {
        String time = service.getFormattedWorkingTime();
        assertTrue(time.matches(regexp));
    }
}