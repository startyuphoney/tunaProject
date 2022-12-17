package com.green.tuna.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final UserSecurityService userSecurityService;
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  
////    	------------------ 페이지 접근 권한 ---------------
    	http
    	.authorizeRequests().antMatchers("/").permitAll()
    	.and()
    	.authorizeRequests().antMatchers("/reservation").authenticated()
    	.and()
    	.authorizeRequests().antMatchers("/myReservation").authenticated()
    	.and()
    	.authorizeRequests().antMatchers("/notice/noticeForm").authenticated()
    	.and()
    	.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
        
////        -------- submit 보안해제 -----------
    	.and()
        	.csrf().ignoringAntMatchers("/**")
        
////        ---------------로그인--------------
    	.and()
	        .formLogin()
	        .loginPage("/login")
	        .defaultSuccessUrl("/")
////	      --------------로그아웃--------------
        .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
//	        
//            
	        ;
	        return http.build();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
}