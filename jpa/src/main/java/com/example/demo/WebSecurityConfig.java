package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
	}
	
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		http.cors().disable();
		http.csrf().disable();
		
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.formLogin().permitAll()
//			.and()
//			.logout().permitAll();
		
		
		http.authorizeRequests()
		.antMatchers("/api/employees/**").hasAnyAuthority("ADMIN", "VIEWER", "CREATOR", "EDITOR")
		.antMatchers("/api/addemployees").hasAnyAuthority("ADMIN", "CREATOR", "EDITOR")
		.antMatchers("/api/updateemployees").hasAnyAuthority("ADMIN", "EDITOR")
		.antMatchers("/api/deleteemployees/**").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().permitAll();
		
//		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/addemployees").hasAnyRole("ADMIN", "CREATOR", "EDITOR")
//		.antMatchers(HttpMethod.PUT).hasAnyRole("ADMIN", "EDITOR")
//		.antMatchers(HttpMethod.DELETE).hasAnyRole("ADMIN")
//		.antMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "VIEWER", "CREATOR", "EDITOR")
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic()
//		.and()
//		.formLogin().permitAll()
//		.and()
//		.logout().permitAll();
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.csrf().disable();
//	}
	
	

}
