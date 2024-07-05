package com.example.webapplicationwithredis.repository;

import com.example.webapplicationwithredis.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
