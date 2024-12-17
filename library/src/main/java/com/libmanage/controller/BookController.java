package com.libmanage.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.libmanage.model.Book;
import com.libmanage.service.BookService;

@Controller
public class BookController implements CommandLineRunner {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) {
        startApplication();
    }

    private void startApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBook Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Search Books");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    bookService.addBook(id, title, author);
                    System.out.println("Book added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Book ID to borrow: ");
                    String id = scanner.nextLine();
                    System.out.println(bookService.borrowBook(id));
                }
                case 3 -> {
                    System.out.print("Enter Book Title to search: ");
                    String title = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByTitle(title);
                    if (books.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        for(Book book : books){
                            System.out.println("ID: "+book.getId());
                            System.out.println("Title: "+book.getTitle());
                            System.out.println("Author: "+book.getAuthor());
                            System.out.println("Borrowed status: "+ (book.isBorrowed() ? "Borrowed" : "Available"));
                            System.out.println();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("List of books available:");
                    System.out.println("----------------------------------------------------");
                    List<Book> allBooks = bookService.getAllBooks();
                    if (allBooks.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        for (int i = 0; i < allBooks.size(); i++) {
                            Book book = allBooks.get(i);
                            System.out.println("No: " + i);
                            System.out.println("Book ID: " + book.getId());
                            System.out.println("Title: " + book.getTitle());
                            System.out.println("Author: " + book.getAuthor());
                            System.out.println("Status: " + (book.isBorrowed() ? "Borrowed" : "Available"));
                            System.out.println("----------------------------------------------------");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}