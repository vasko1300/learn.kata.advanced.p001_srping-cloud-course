package ru.vasko1300.clientservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.vasko1300.clientservice.model.Book;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookServiceClient {
    @GetMapping("/api/books")
    List<Book> getAllBooks();
}
