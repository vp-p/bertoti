package com.example.projeto03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto03.entities.Book;

public interface BookRepo extends JpaRepository<Book, String> {
}
