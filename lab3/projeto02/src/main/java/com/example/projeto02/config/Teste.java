package com.example.projeto02.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projeto02.entities.Book;
import com.example.projeto02.repositories.BookRepo;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner {

    @Autowired
    private BookRepo bookRepository;

    @Override
    public void run(String... args) throws Exception{
        Book metamorfose = new Book (null, "Metamorfose", 96);
        
        bookRepository.saveAll(Arrays.asList(metamorfose));
        
    }
}
