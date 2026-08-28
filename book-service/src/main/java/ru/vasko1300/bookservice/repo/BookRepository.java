package ru.vasko1300.bookservice.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.vasko1300.bookservice.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

}
