package com.example.webapplicationwithredis.service;

import com.example.webapplicationwithredis.exception.BookNotFoundException;
import com.example.webapplicationwithredis.entity.Book;
import com.example.webapplicationwithredis.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        List<Book> foundBooks = new ArrayList<>();
        bookRepository.findAll().forEach(foundBooks::add);
        logger.info("All books returned");
        return foundBooks;
    }

    @Override
    public Book getBookById(Long id) {
        Book foundBook = bookRepository.findById(id).orElse(null);
        if (Objects.isNull(foundBook)){
            logger.error("Book not found");
            throw new BookNotFoundException("Book not found");
        }
        return foundBook;
    }

    @Override
    public Book addBook(Book book) {
        logger.info("Book added");
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        if (bookRepository.existsById(book.getId())){
            logger.info("Book updated");
            return bookRepository.save(book);
        }
        logger.error("Book not found");
        throw new BookNotFoundException("Book not found");
    }

    @Override
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)){
            logger.info("Book deleted");
            bookRepository.deleteById(id);
        }
        logger.error("Book not found");
        throw new BookNotFoundException("Book not found");
    }
}
