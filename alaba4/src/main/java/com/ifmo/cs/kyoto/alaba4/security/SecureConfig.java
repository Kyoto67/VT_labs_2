package com.ifmo.cs.kyoto.alaba4.security;

import com.ifmo.cs.kyoto.alaba4.auth.RestAuthenticationEntryPoint;
import com.ifmo.cs.kyoto.alaba4.auth.AuthFilter;
import com.ifmo.cs.kyoto.alaba4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecureConfig {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private UsersService userService;

    @Autowired
    RestAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthFilter filter(){
        return new AuthFilter();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(encoder);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable().httpBasic().disable()
                .exceptionHandling().authenticationEntryPoint(entryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(filter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().antMatchers("/auth/**").permitAll().anyRequest().authenticated();
        return http.build();
    }


    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOriginPatterns("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }

}
