package com.mabotalb.employees_rest_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // Add support for JDBC ... no more hardcoding users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT user_id, pw, active FROM members WHERE user_id =?");

        // Define query to retrieve authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_id, role FROM roles WHERE user_id =?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        String pathPattern = "/api/v1/employees";

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET, pathPattern).hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, pathPattern + "/**").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, pathPattern).hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, pathPattern).hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, pathPattern + "/**").hasRole("ADMIN"));

        // Use HTTP Basic Authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable Cross Site Request Forgery (CSRF) protection
        // In general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH methods
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
     */
}
