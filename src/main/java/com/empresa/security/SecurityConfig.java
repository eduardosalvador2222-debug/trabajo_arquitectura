package com.empresa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

	private final UserDetailsService userDetailsService;
	private final JwtEntryPoint jwtEntryPoint;
	private final JwtProvider jwtProvider;

	@Bean
	JwtTokenFilter jwtTokenFilter() {
		return new JwtTokenFilter(jwtProvider, userDetailsService);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider =
				new DaoAuthenticationProvider(userDetailsService);

		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(
			AuthenticationConfiguration authConfiguration)
			throws Exception {

		return authConfiguration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http)
			throws Exception {

		http.csrf(csrf -> csrf.disable())
			.exceptionHandling(
					exp -> exp.authenticationEntryPoint(jwtEntryPoint))
			.sessionManagement(
					session -> session.sessionCreationPolicy(
							SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(
					auth -> auth
							.requestMatchers("/api/auth/**").permitAll()
							.requestMatchers("/api/usuario").permitAll()
							.anyRequest()
							.authenticated());

		http.authenticationProvider(
				authenticationProvider());

		http.addFilterBefore(
				jwtTokenFilter(),
				UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}