package tn.showroom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.showroom.Service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	
	// La méthode configure(HttpSecurity http) Configuration des utilisateurs authentifiés et autorisés
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// La page /registration ne demande pas une authentification
		http.authorizeRequests().antMatchers("/registration").permitAll()
				.antMatchers("/client/remove-client/**").access("hasRole('SUPERADMIN')")
				.antMatchers("/get**}").access("hasRole('ADMIN')")
				.antMatchers("/client/retrieve-all-clients").access("hasRole('ADMIN')")
				.anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}
}
