package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
//                .antMatchers("/api/read").permitAll()
                .antMatchers(HttpMethod.POST,"/api/create").permitAll()
                .antMatchers(HttpMethod.GET,"/api/read").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.PUT,"/api/update").hasAnyRole("ADMIN","USER")
                .antMatchers(HttpMethod.DELETE,"api/delete").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = (UserDetails) User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
       UserDetails admin = (UserDetails) User.withDefaultPasswordEncoder()
               .username("admin")
               .password("admin")
               .roles("ADMIN")
               .build();
        return new InMemoryUserDetailsManager(user, admin);

    }
}
