package com.practive.course.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/","/index","/login","/registration")
		.permitAll()
		.antMatchers("/student/**").hasAuthority("STUDENT")
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.anyRequest().fullyAuthenticated()
		
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/dashboard")
		.and()
		.exceptionHandling().accessDeniedPage("/failure");
		
		http.csrf().disable();
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
