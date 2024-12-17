package com.libmanage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.libmanage.model.Book;
import com.libmanage.repo.BookRepo;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(String id, String title, String author) {
        Book book = new Book(id, title, author);
        bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public String borrowBook(String id) {
        Optional<Book> bookOpt = bookRepo.findById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isBorrowed()) {
                return "Book is already borrowed.";
            }
            book.setBorrowed(true);
            bookRepo.save(book);
            return "Book borrowed successfully.";
        }
        return "Book not found.";
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepo.findByTitleContainingIgnoreCase(title);
    }
}