package com.ust.pms.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	//in menory authentication 
	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder
	 * authenticationManagerBuilder)throws Exception{
	 * authenticationManagerBuilder.inMemoryAuthentication()
	 * .withUser("dhananjay").password("kumar").authorities("ROLE_ADMIN").and()
	 * .withUser("kiran").password("kumar").authorities("ROLE_USER").and()
	 * .withUser("karim").password("khan").authorities("ROLE_USER").and()
	 * .withUser("swati").password("kumar").authorities("ROLE_ADMIN","ROLE_USER"); }
	 */
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void  configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)throws Exception{	
		authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource);
	}
	//authorization
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/index").hasAnyRole("USER","ADMIN")
		.antMatchers("/addProducts").hasAnyRole("ADMIN")
		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();

		//cros site request frogery
		http.csrf().disable();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	public JdbcUserDetailsManager jdbcUserDetailsManager() {
		JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(dataSource);
		return jdbcUserDetailsManager;
	}
	

}
