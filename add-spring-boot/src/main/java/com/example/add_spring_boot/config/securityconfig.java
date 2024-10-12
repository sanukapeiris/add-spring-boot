package com.example.add_spring_boot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class securityconfig {
    @Value("${secure.username}")
    private String username;
    @Value("${secure.password}")
    private String password;
    @Value("${secure.role}")
    private String role;


    SecurityFilterChain securityFilterChain (HttpSecurity http) throws  Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails principleuser = User.withDefaultPasswordEncoder()
                .username(username)
                .password(password)
                .roles(role).build();
        return new InMemoryUserDetailsManager(principleuser);
    }
}
