package org.restWebService.BPlayer.security;

import org.restWebService.BPlayer.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BUserService bUserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.cors().and()
			.authorizeRequests()
				.antMatchers("/")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/login")
				.permitAll()
				.antMatchers(HttpMethod.POST, "/buser/register")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				// We filter the api/login requests
				.addFilterBefore(
						new JWTLoginFilter(bUserService,"/login", authenticationManager()),
						UsernamePasswordAuthenticationFilter.class)
				// And filter other requests to check the presence of JWT in
				// header
				.addFilterBefore(new JWTAuthenticationFilter(),
						UsernamePasswordAuthenticationFilter.class);
	}

}