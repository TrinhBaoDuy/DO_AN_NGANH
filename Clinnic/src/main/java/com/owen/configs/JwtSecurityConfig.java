/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.configs;
//
//import com.dht.filters.CustomAccessDeniedHandler;
//import com.dht.filters.JwtAuthenticationTokenFilter;
//import com.dht.filters.RestAuthenticationEntryPoint;
import com.owen.filters.CustomAccessDeniedHandler;
import com.owen.filters.JwtAuthenticationTokenFilter;
import com.owen.filters.RestAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 *
 * @author hung
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.owen.controllers",
    "com.owen.repository",
    "com.owen.service", 
    "com.owen.components"})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


      @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Disable crsf cho đường dẫn /rest/**
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/api/login/**").permitAll();
        http.authorizeRequests().antMatchers("/api/nurse/**").permitAll();
        http.authorizeRequests().antMatchers("/api/medicines/**").permitAll();
        http.authorizeRequests().antMatchers("/api/swagger-ui.html").permitAll();
        http.authorizeRequests().antMatchers("/api/current-user/**").permitAll();
        http.authorizeRequests().antMatchers("/api/appointments/**").permitAll();
        http.authorizeRequests().antMatchers("/api/**").permitAll();

        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
<<<<<<< HEAD
                .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON') ")
                .antMatchers(HttpMethod.POST, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON')")
                .antMatchers(HttpMethod.DELETE, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON')") 
=======
                .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON') or hasRole('ROLE_DOCTOR')orhasRole('ROLE_NURSE')")
                .antMatchers(HttpMethod.POST, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON')or hasRole('ROLE_DOCTOR')orhasRole('ROLE_NURSE')")
                .antMatchers(HttpMethod.DELETE, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_SICKPERSON') or hasRole('ROLE_DOCTOR')orhasRole('ROLE_NURSE')")
>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
                
                .antMatchers(HttpMethod.GET, "/api/doctor/**").access("hasRole('ROLE_DOCTOR')")
                .antMatchers(HttpMethod.POST, "/api/doctor/**").access("hasRole('ROLE_DOCTOR')")
                .antMatchers(HttpMethod.DELETE, "/api/doctor/**").access("hasRole('ROLE_DOCTOR')")
                
                .antMatchers(HttpMethod.GET, "/api/nurse/**").access("hasRole('ROLE_NURSE')")
                .antMatchers(HttpMethod.POST, "/api/nurse/**").access("hasRole('ROLE_NURSE')")
                .antMatchers(HttpMethod.DELETE, "/api/nurse/**").access("hasRole('ROLE_NURSE')").and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
<<<<<<< HEAD
=======
 


>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
}
