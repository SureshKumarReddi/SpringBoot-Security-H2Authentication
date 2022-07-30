package com.Suresh.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.withDefaultSchema()
		.withUser(User.withUsername("admin")
				.password("{noop}admin")
				.roles("ADMIN"))
		.withUser(User.withUsername("suresh")
				.password("{noop}suresh")
				.roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/home").hasAnyRole("ADMIN","USER")
		.antMatchers("/contact").permitAll()
		.antMatchers("/loan").hasRole("USER")
		.antMatchers("/statement").hasRole("USER")
		.antMatchers("/balance").hasRole("USER")
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}

	//remove this comments when we remove the {noop} from .password("{noop}admin")
	//then it requires the NoopPasswordEncoder beanfor that..
	
	/* 
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
}
