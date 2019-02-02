package com.mycompany.example.myapplication;

import com.mycompany.example.myapplication.categories.FastTests;
import com.mycompany.example.myapplication.categories.SlowTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SimpleMathTest {
    SimpleMath sm;

    @Rule
    public ReportTestExecution exec = new ReportTestExecution();

    @Before
    public void setup() {
        sm = new SimpleMath();
        // sysout to simulate call to Web service
        //System.out.println("Sending to Web service:  about to execute test method in SimpleMathTest.");
    }

    @After
    public void tearDown() {
        // sysout to simulate call to Web service
        //System.out.println("Sending to Web service:  done executing test method in SimpleMathTest.");
    }

    @Category(FastTests.class) //The testAdd() is now a part of FastTests Category
    @Test
    public void testAdd() {
        assertEquals("SimpleMath addition not adding correctly", 9, sm.add(4, 5));
    }

    @Category(SlowTests.class) //The testDiff() is now a part of SlowTests Category
    @Test
    public void testDiff() {
        assertEquals("SimpleMath diff not subtracting correctly", 5, sm.diff(12, 7));
    }
}



