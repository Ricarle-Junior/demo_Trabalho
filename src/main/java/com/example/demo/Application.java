package com.example.demo;
//Pacote onde esta classe está guardada.//
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Diz que esta é a classe principal do Spring Boot.//
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}   // Inicia a aplicação Spring Boot e sobe o servidor.//
