package com.example.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto01.entities.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
