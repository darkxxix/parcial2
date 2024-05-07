package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("admin")
				.password("admin").roles( "ADMIN").and().withUser("user").password("user").roles("USER");
	}
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/h2-console/").permitAll().antMatchers("/add-todo","/todo/")
				.access("hasRole('ADMIN')").antMatchers( "/todo/").access("hasRole('USER')").and().formLogin();
		

		http.csrf().disable();
		http.headers().frameOptions().disable();
        return http.build();
	}
}