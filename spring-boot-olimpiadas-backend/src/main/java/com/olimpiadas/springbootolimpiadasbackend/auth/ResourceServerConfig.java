package com.olimpiadas.springbootolimpiadasbackend.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/entrenadores", "/api/entrenadores/page/**", "/api/uploads/img/**").permitAll()
                /*.antMatchers(HttpMethod.GET, "/api/entrenadores/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/entrenadores/upload").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/entrenadores").hasRole("ADMIN")
                .antMatchers("/api/entrenadores/**").hasRole("ADMIN")*/
                .anyRequest().authenticated();
    }


}
