package com.it_academy.onliner.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webDriver.DriverManager;

public class DriverHooks {
    @Before
    public void setupDriver() {
        DriverManager.setDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
