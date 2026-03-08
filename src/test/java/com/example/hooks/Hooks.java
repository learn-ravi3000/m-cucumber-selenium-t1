package com.example.hooks;

import com.example.config.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.createDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
