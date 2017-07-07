package com.se.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.se.security.TokenAuthenticationService;
import com.se.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebsecurityConfig extends WebSecurityConfigurerAdapter {
	private UserService userService;
	private TokenAuthenticationService tokemAuthenticationService;
	

	public WebsecurityConfig(UserService userService, TokenAuthenticationService tokemAuthenticationService) {
		super();
		this.userService = userService;
		this.tokemAuthenticationService = tokemAuthenticationService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/bootstrap/**","/css/**","/font/**","/fonts/**","/jexecl/**","/pace/**","/search/**","skin-select/**","/test/**","/img/**","/js/**","/font-awesome","/linearicons/**","/templatemo/**").permitAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/manage/news").permitAll().and()
			.logout().permitAll();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	 @Override
	 public UserDetailsService userDetailsService() { 
	        return userService;
	    }

	

}
