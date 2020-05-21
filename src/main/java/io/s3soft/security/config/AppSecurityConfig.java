package io.s3soft.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.s3soft.security.AccessDeniedHandlerImpl;
import io.s3soft.service.impl.ApplicationUserDetailsService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandler;


	@Bean public BCryptPasswordEncoder passwordEncoder() { return new
			BCryptPasswordEncoder(); }
	

	
	@Autowired
	private ApplicationUserDetailsService appUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		    .loginPage("/perform-login").permitAll()
		    .defaultSuccessUrl("/",true)
		    .usernameParameter("user-name")
		    .passwordParameter("password")
		    .loginProcessingUrl("/perform-auth")
		    .failureUrl("/perform-login?authError=true")
		.and()
		.logout().permitAll()
		.logoutSuccessUrl("/perform-login?logout=true")
		.and()
		  .exceptionHandling()
		     .accessDeniedHandler(accessDeniedHandler);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthProvider=new DaoAuthenticationProvider();
		daoAuthProvider.setPasswordEncoder(passwordEncoder());
		daoAuthProvider.setUserDetailsService(appUserDetailsService);
		return daoAuthProvider;
	}


}
