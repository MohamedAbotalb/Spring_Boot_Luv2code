package com.mabotalb.mvc_security_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

        // Add support for JDBC
        @Bean
        public UserDetailsManager userDetailsManager(DataSource dataSource) {

                JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

                // Define query to retrieve a user by username
                jdbcUserDetailsManager.setUsersByUsernameQuery(
                        "SELECT user_id, pw, active FROM members WHERE user_id = ?");

                // Define query to retrieve the authorities/roles by username
                jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                        "SELECT user_id, role FROM roles WHERE user_id =?");

                return jdbcUserDetailsManager;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

                http.authorizeHttpRequests(configurer -> configurer
                                .requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasRole("MANAGER")
                                .requestMatchers("/systems/**").hasRole("ADMIN")

                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/showLoginPage")
                                                .loginProcessingUrl("/authenticateUser")
                                                .permitAll())
                                .logout(LogoutConfigurer::permitAll)
                                .exceptionHandling(configurer -> configurer
                                                .accessDeniedPage("/access-denied"));

                return http.build();
        }

        /*
        @Bean
        public InMemoryUserDetailsManager userDetailsManager() {

                String password = "{noop}test123";

                UserDetails john = User.builder()
                                .username("john")
                                .password(password)
                                .roles("EMPLOYEE")
                                .build();

                UserDetails mary = User.builder()
                                .username("mary")
                                .password(password)
                                .roles("EMPLOYEE", "MANAGER")
                                .build();

                UserDetails susan = User.builder()
                                .username("susan")
                                .password(password)
                                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                                .build();

                return new InMemoryUserDetailsManager(john, mary, susan);
        }
        */
}
