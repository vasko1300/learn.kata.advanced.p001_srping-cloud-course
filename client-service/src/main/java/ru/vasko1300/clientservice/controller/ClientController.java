package ru.vasko1300.clientservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasko1300.clientservice.client.BookServiceClient;
import ru.vasko1300.clientservice.model.Book;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
@Slf4j
public class ClientController {
    private final BookServiceClient bookServiceClient;

    @GetMapping("/books")
    public List<Book> getAllBooksFromClient() {
        log.info("Getting all books from Client");
        List<Book> books = bookServiceClient.getAllBooks();
        log.info("Returning {} books", books.size());
        return books;
    }
}
