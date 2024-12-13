package com.libmanage.service;

import com.libmanage.model.Book;
import com.libmanage.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void addBook(String id, String title, String author) {
        Book book = new Book(id, title, author);
        bookRepo.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public String borrowBook(String id) {
        Optional<Book> bookOpt = bookRepo.findBookById(id);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            if (book.isBorrowed()) {
                return "Book is already borrowed.";
            }
            book.setBorrowed(true);
            return "Book borrowed successfully.";
        }
        return "Book not found.";
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepo.getAllBooks().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()))
                .toList();
    }
}
