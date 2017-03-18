package org.restWebService.BPlayer.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.service.BUserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
	
	private final BUserService bUserService;

	public JWTLoginFilter(final BUserService bUserService, String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
		this.bUserService = bUserService;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,	HttpServletResponse res) throws AuthenticationException,
			IOException, ServletException {
		AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
		
		BUser bUser = bUserService.findByUsernameAndPassword(creds.getUsername(),creds.getPassword());
		
		if(bUser==null){
			throw new UsernameNotFoundException("User not found: " + creds.getUsername());
		}
		
		return new UsernamePasswordAuthenticationToken(creds.getUsername(),	null, Collections.emptyList());
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res, FilterChain chain, Authentication auth)
			throws IOException, ServletException {
		TokenAuthenticationService.addAuthentication(res, auth.getName());
	}
}