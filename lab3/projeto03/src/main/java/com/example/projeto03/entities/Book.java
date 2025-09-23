package com.example.projeto03.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_books")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private final String id;
    private String name;
    private Integer pages;

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public Book(String name) {
        this(UUID.randomUUID().toString(), name, null);
    }

    public Book(String id, String name, Integer pages) {
        this.id = id != null ? id : UUID.randomUUID().toString();
        this.name = name;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return id != null && id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", pages=" + pages + "]";
    }
}