/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Hillary
 */
@Configuration
@EnableWebSecurity
//WebSecurityConfigurerAdapter va a correr todo lo de seguriidad para iniciar 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    //Encripta la contrasena
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //SETTEAR EL TIPO DE ENCRIPTACION
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }

    //Los bean es especifico para lo de configuration
    // @Bean
// es como el autowire que inyectaba dependencias, peeero inyectamos dependencias pero de configuracion que debe hacer el programa cuando se esta ejecutando
    //que hago si la autenticacion fue exitosa
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persona", "/login", "/personasN") //paginas a las que tiene acceso
                .hasRole("ADMIN") //tipo del role
                .antMatchers("/persona", "/", "/login") //a donde tiene el acceso
                .hasAnyRole("USER", "VENDEDOR", "ADMIN") //role
                .anyRequest().authenticated() //requests todos autenticados
                .and()
                .formLogin()
                //si es exitoso me reenvia aca 
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona", true);
    }
}
