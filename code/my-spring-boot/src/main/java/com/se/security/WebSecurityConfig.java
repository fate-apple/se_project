package com.se.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity security){
	    security.ignoring().antMatchers("/css/**","/font-awesome/**","/bootstrap/**","/img/**","/js/**","/linearicons/**","/templatemo/**");
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        http
            
            .authorizeRequests()
                .antMatchers("/se").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/se")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

}