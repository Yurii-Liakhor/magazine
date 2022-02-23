package com.example.magazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/magazine.html", "/magazine/add", "/magazine/delete").hasRole("ADMIN")
                .antMatchers("/subscription.html", "/subscription/**", "/magazine/all").hasAnyRole("USER", "ADMIN")
                .antMatchers("/hello", "/registration", "/register").permitAll()
                .and()
                .formLogin()
                .defaultSuccessUrl("/index.html", true)
                .and()
                .logout();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("pass").roles("USER")
//                .and()
//                .withUser("admin").password("pass").roles("ADMIN");

//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                    "select login, password, 'true' from user " +
                            "where login=?")
                .authoritiesByUsernameQuery(
                        "select login, authority from user " +
                                "where login=?");
    }
}