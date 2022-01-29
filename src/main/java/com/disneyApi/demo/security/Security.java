/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disneyApi.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Flor
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Security extends WebSecurityConfigurerAdapter {

   
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/*", "/js/*", "/img/*",
                        "/**").permitAll()
                .and().
                formLogin()
                .loginPage("/index")
                .loginProcessingUrl("/logincheck")
                .passwordParameter("password")
                .defaultSuccessUrl("/inicio") 
                .permitAll()
                .and().logout()
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/login?logout")             
                .permitAll().
                and().csrf().disable();
    }
}
