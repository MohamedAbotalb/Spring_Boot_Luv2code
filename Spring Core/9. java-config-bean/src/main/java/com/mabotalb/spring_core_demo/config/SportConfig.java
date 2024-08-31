package com.mabotalb.spring_core_demo.config;

import com.mabotalb.spring_core_demo.common.Coach;
import com.mabotalb.spring_core_demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }

}
