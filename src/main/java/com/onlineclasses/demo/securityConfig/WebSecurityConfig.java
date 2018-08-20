package com.onlineclasses.demo.securityConfig;

import com.onlineclasses.demo.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Qualifier("customUserDetailsService")
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
	}

	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/admin/**")
					.access("hasRole('ROLE_ADMIN')")
					.and()
					.formLogin()
					.loginPage("/login").permitAll()
					.loginProcessingUrl("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.and().logout().and().exceptionHandling()
					.accessDeniedPage("/403").and().csrf().disable();
		}



	@Bean(name = "passwordEncoder")
	public PasswordEncoder passwordencoder() {
		System.out.println("Password is :" + new BCryptPasswordEncoder().encode("java"));
		return new BCryptPasswordEncoder();
	}


}