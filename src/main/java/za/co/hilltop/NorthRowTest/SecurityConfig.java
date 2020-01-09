package za.co.hilltop.NorthRowTest;

import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//This is for the end point
		http.httpBasic().and().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
			.anyRequest().authenticated().and().csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("ADMIN");
	}
}
