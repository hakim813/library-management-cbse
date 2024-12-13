package com.libmanage.controller;

import com.libmanage.model.Book;
import com.libmanage.service.BookService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
        startApplication();
    }

    private void startApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Book Management System");
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
                    bookService.searchBooksByTitle(title)
                            .forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("This is the list of books available.\n----------------------------------------------------");
                     List<Book> allBooks = bookService.getAllBooks();
                     for(Book book : allBooks){
                         System.out.println("No : "+allBooks.indexOf(book));
                         System.out.println("Book ID : "+book.getId());
                         System.out.println("Title : "+book.getTitle());
                         System.out.println("Author : "+book.getAuthor());
                         System.out.println("----------------------------------------------------");
                     }

                }
                case 5 -> {
                    System.out.println("Exiting the program.");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
