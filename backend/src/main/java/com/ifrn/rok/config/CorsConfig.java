package com.ifrn.rok.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CorsConfig implements WebMvcConfigurer {

    // Cors = Cross-Origin Resource Sharing -> mecanismo de segurança dos navegadores.
    // O Cors estava bloqueando as requisições enviadas ao backend pq o front e o back se conectam por portas diferentes.

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // endpoints afetados
                .allowedOrigins("http://127.0.0.1:5173") // origem permitida (nesse caso, o localhost com a porta do vue)
                .allowedMethods("POST", "GET", "DELETE", "PUT", "OPTIONS") // métodos http permitidos
                .allowedHeaders("*") // headers permitidos
                .allowCredentials(true); // credentials permite o envio de cookies, sessão e headers de autenticação.
    }
}
