package com.dh.bd.test.ms.bd.test.config.auth;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


/**
 * @author dpanquev
 * esta clase es para asegurar nuestros recursos en spring boot
 */
@Configuration
@EnableResourceServer
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * por cada metodo le estoy diciendo a spring boot que me lo proteja de acuerdo a quien puede o no
     * ingresar a el según su rol
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        /** public routes*/
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/listAcc", "/api/v1/detail/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/create-test").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/create-image").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource())
        ;

    }

    /**
     * Le estoy diciendo a spring boot que abra y tenga los metodos permitidos para que las aplicaciones puedan
     * ingresar a el, ya sea con las funciones GET, PUT.... Tambien le registro los headers
     * Tambien le puedo decir que el unico canal de conexión sera la ip de mi front, http://localhost:4200 en
     * este caso para ustedes sería colocar la url de su front, y sera la unica que se pueda conectar a nuestro back
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }

    /**
     * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
     * de esta manera uso e implemento el registro y apertura de los cors
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
