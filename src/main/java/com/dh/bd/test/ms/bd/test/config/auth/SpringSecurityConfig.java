package com.dh.bd.test.ms.bd.test.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Actualización para deprecated WebSecurityConfigurerAdapter
 */
//@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    /**
     * Registrando BCryptPasswordEncoder para poder utilizarlo e implementarlo en todo el ecosistema
     * de spring boot.
     */
    @Bean
    private static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
    }*/

    /**
     * Inicializando y registrando nuestro metodo de autenticación, es decir, es el que nos da el contexto del uso
     * de los metodos de autenticación, es el gestor de autenticacion.
     * Se registra porque hay librerias de oauth2 y jwt que las implementan y aquí lo que estamos diciendo es que
     * use nuestro bean que es el que tiene el contexto de nuestra aplicación.
     */
    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    /*@Bean("authenticationManager")
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }*/

    /**
     * Registro la seguridad para que no sea una clase con estado ni una seguridad por sesiones
     * esto se hace a partir de mi metodo de autorización jwt
     */
    // @Override
    @Bean
    public HttpSecurity configure(HttpSecurity http) throws Exception {
        /** public routes*/
        return http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                ;
    }


}
