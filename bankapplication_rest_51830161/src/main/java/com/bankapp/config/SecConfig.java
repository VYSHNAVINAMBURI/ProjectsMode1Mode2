package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

@EnableWebSecurity
public class SecConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	/* @Autowired private BasicAuthenticationEntryPoint authenticationEntryPoint; */

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
//		auth.inMemoryAuthentication()
//		.withUser("raj").password("raj").roles("ADMIN")
//		.and()
//		.withUser("ektha").password("ektha").roles("MGR");
		
	}

	@Bean
	public BCryptPasswordEncoder getEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);
		
		http.httpBasic().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		.authorizeRequests()
		.antMatchers("/api/user/**").hasAnyRole("ADMIN")
		.antMatchers("/api/account/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/api/transaction/**").hasAnyRole("ADMIN","MGR","CLERK")
		.antMatchers("/hello/**").authenticated();

	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//		.antMatchers("/api/user/**").hasAnyRole("ADMIN")
//		.antMatchers("/api/account/**").hasAnyRole("MGR","ADMIN")
//		.antMatchers("/api/transaction/**").hasAnyRole("CLERK","MGR","ADMIN").and().httpBasic();
//	}

}






//.and().formLogin();
//.loginPage("/login").loginProcessingUrl("/myloginaction")
//.usernameParameter("username").passwordParameter("password")
//.defaultSuccessUrl("/hello")
//.permitAll()
//.and()
//.httpBasic()
//.and()
//.exceptionHandling().accessDeniedPage("/accessdenied")
//.and().sessionManagement().maximumSessions(1);
