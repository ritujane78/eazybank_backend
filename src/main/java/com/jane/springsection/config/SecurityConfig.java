package com.jane.springsection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {
    PasswordEncoder passwordEncoder;
    CompromisedPasswordChecker checker;

    public SecurityConfig(PasswordEncoder passwordEncoder, CompromisedPasswordChecker checker) {
        this.passwordEncoder = passwordEncoder;
        this.checker = checker;
    }

    public void validatePassword(String password){
        CompromisedPasswordDecision decision = checker.check(password);
        if (decision.isCompromised()) {
            throw new IllegalArgumentException(
                    "Password has been compromised in a data breach"
            );
        }
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorizeRequests -> authorizeRequests.
                requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                        .requestMatchers("/myContact","/myNotices", "/error").permitAll()
        );
//        http.formLogin(flc -> flc.disable());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

}
