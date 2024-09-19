package com.mabotalb.aop_demo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneServiceImpl implements TrafficFortuneService {

    @Override
    public String getFortune() {

        // Simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            throw new InterruptedException(ex);
        }

        // Return the fortune
        return "Expect heavy traffic this morning!";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        // Return the fortune
        return getFortune();
    }

}
