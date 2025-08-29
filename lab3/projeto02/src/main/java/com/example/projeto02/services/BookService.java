package com.example.projeto01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto01.entities.Book;
import com.example.projeto01.repositories.BookRepo;



@Service
public class BookService {

    @Autowired
    private BookRepo repository;

    public List<Book> findAll(){
        return repository.findAll();
    }
    
    public Book findById(Long id){
        Optional<Book> obj = repository.findById(id);
        return obj.get();
    }

	public Book insert(Book obj) {
		return repository.save(obj);
	}

    public void delete(Long id) {
		repository.deleteById(id);
	}

    public Book update(Long id, Book obj) {
		Book entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Book entity, Book obj) {
		entity.setName(obj.getName());
		entity.setPages(obj.getPages());
	}
    
}
