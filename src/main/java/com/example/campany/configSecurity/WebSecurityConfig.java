package com.example.campany.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.campany.service.UserDetailsServiceIMPL;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceIMPL userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
/*- @EnableWebSecuritypermet à Spring de trouver et d'appliquer automatiquement la classe à la sécurité Web globale.

- @EnableGlobalMethodSecurityfournit une sécurité AOP sur les méthodes. Il permet @PreAuthorize, @PostAuthorizeil prend également en charge JSR-250 . Vous pouvez trouver plus de paramètres dans la configuration dans les expressions de sécurité de méthode .

- Nous remplaçons la configure(HttpSecurity http)méthode de l' WebSecurityConfigurerAdapterinterface. Il indique à Spring Security comment nous configurons CORS et CSRF, quand nous voulons exiger que tous les utilisateurs soient authentifiés ou non, quel filtre ( AuthTokenFilter) et quand nous voulons qu'il fonctionne (filtrer avant UsernamePasswordAuthenticationFilter), quel gestionnaire d'exceptions est choisi ( AuthEntryPointJwt).

- Spring Security chargera les détails de l'utilisateur pour effectuer l'authentification et l'autorisation. Il a donc une UserDetailsServiceinterface que nous devons implémenter.

- L'implémentation de UserDetailsServicesera utilisée pour la configuration DaoAuthenticationProviderpar AuthenticationManagerBuilder.userDetailsService()méthode.

- Nous avons également besoin d'un PasswordEncoderpour le DaoAuthenticationProvider. Si nous ne le précisons pas, il utilisera du texte brut.*/
