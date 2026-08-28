package ru.vasko1300.bookservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.vasko1300.bookservice.model.Book;
import ru.vasko1300.bookservice.repo.BookRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        if (bookRepository.findAll().isEmpty()) {
            log.info("\uD83D\uDCDA No books found. Adding test books to MongoDB");
            Book book1 = Book.builder()
                    .title("Война и мир")
                    .description("Эпик")
                    .imageLink("https://static.irk.ru/static/img/irkru-logo-min.a0554ed5ab95.svg")
                    .build();
            Book book2 = Book.builder()
                    .title("1984")
                    .description("Антиутопия")
                    .imageLink("https://static.irk.ru/media/img/site/option/image/4a28bcc9-7ddf-4af4-9af7-1f8aede22f67.svg")
                    .build();
            bookRepository.saveAll(List.of(book1, book2));
            log.info("✅ {} books added", bookRepository.count());
        }
    }
}
