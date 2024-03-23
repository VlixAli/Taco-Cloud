package com.seinfeld.tacocloud.configurations;

import com.seinfeld.tacocloud.models.User;
import com.seinfeld.tacocloud.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .requestMatchers(HttpMethod.POST, "admin/**").access("hasRole('ADMIN')")
                .requestMatchers("/design", "/orders").access("hasRole('USER')")
                .requestMatchers("/", "/**").access("permitAll()")

                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design", true)

                .and()
                .oauth2Login()
                .loginPage("/login")

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null) return user;

            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
