package bralis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authenticationProvider;

	   @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

	        httpSecurity      
	        	.headers()
	        		.frameOptions().disable() // Enable view PDF file
	        	.and()	
	            .csrf()
	                .disable() // Disable CSRF protection (stateless JWT authentication)
	            .authorizeRequests()
	                .requestMatchers("/register", "/login") // Allow these routes without authentication
//	                .requestMatchers("/*/**") // Allow these routes without authentication
	                    .permitAll()
                .requestMatchers("/admin/**") // Restrict access to admin routes
	                    .hasRole("ADMIN") // Only users with "ADMIN" role can access /admin/**
	                .anyRequest() // Any other request must be authenticated
	                    .authenticated()
	            .and()
	            .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions, stateless authentication
	            .and()
	            .authenticationProvider(authenticationProvider) // Use the custom authentication provider
	            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add JWT filter
	            .cors() // Enable CORS
	            .and()
	            .formLogin()
	                .disable(); // Disable default form-based login (we use JWT authentication)

	        return httpSecurity.build();
	    }

}