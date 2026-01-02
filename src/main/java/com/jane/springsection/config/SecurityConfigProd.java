package com.jane.springsection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;


@Configuration
@Profile("prod")
public class SecurityConfigProd {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .redirectToHttps((https) -> https.requestMatchers(AnyRequestMatcher.INSTANCE)) // Only HTTPS
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                authorizeRequests -> authorizeRequests.
                requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                        .requestMatchers("/myContact","/myNotices", "/error", "/register").permitAll()
        );
//        http.formLogin(flc -> flc.disable());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

}
