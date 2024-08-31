package com.mabotalb.spring_core_demo.rest;

import com.mabotalb.spring_core_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final Coach myCoach;
    private final Coach anotherCoach;

    // Define a constructor injection
    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach myCoach,
                          @Qualifier("baseballCoach") Coach anotherCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans: myCoach == anotherCoach => " + (this.myCoach == this.anotherCoach);
        // Singleton scope -> return true
        // Prototype scope -> return false
    }
}
