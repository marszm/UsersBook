package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        http.authorizeRequests()
//                .antMatchers("/api/read").permitAll()
                .antMatchers("/api/create").permitAll()
                .antMatchers("/api/read").hasAnyRole("ADMIN","USER")
                .antMatchers("/api/update").hasAnyRole("ADMIN","USER")
                .antMatchers("api/delete").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
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
