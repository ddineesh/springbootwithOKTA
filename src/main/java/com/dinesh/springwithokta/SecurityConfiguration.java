package com.dinesh.springwithokta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(passwordEncoder())
            .withUser("dinesh")
            .password(passwordEncoder().encode("secret"))
            .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }
}

/*
 * @Configuration public class SecurityConfigurations extends
 * WebSecurityConfigurerAdapter{
 * 
 * private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
 * 
 * @Autowired public void configureGlobalSecurity(AuthenticationManagerBuilder
 * auth) throws Exception {
 * auth.inMemoryAuthentication().withUser("dinesh").password("{noop}admin")
 * .roles("USER", "ADMIN"); }
 * 
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.inMemoryAuthentication() .passwordEncoder(passwordEncoder())
 * .withUser("dinesh") .password(passwordEncoder().encode("admin"))
 * .roles("USER"); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return passwordEncoder; }
 * 
 * 
 * }
 */