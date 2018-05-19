package br.com.abutres.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	    	.antMatchers(
	    			"/resources/**",
	    			"/static/**",
	    			"/css/**",
	    			"/fonts/**",
	    			"/images/**",
	    			"/js/**",
	    			"/vendor/**",
	    			"/webjars/**",
	    			"/"
	    	).permitAll()
	       // .anyRequest().authenticated()
	    	.anyRequest().permitAll()
	        .and()
	    .formLogin()
	        .loginPage("/login").permitAll()
	        .and()
        .logout().permitAll()
        .and()
	    .rememberMe();
	}
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
      builder
          .inMemoryAuthentication()
          .withUser("teste").password("123")
              .roles("USER")
          .and()
          .withUser("zico").password("123")
              .roles("USER");
    }
}