package com.sn.atos.atosspringsecurityjwt.service;

import com.sn.atos.atosspringsecurityjwt.model.Book;
import com.sn.atos.atosspringsecurityjwt.repository.RepositoryBook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final RepositoryBook repositoryBook;

    // private final KafkaTemplate<String , String> kafkaTemplate;
    private final KafkaTemplate<String , Book> kafkaTemplate;

    private static final String TOPIC="json-web-books";

    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(RepositoryBook repositoryBook, KafkaTemplate<String, Book> kafkaTemplate) {
        this.repositoryBook = repositoryBook;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Iterable<Book> getBooks(){
        return repositoryBook.findAll();
    }

    public Book create(Book bookDetails){
        Book book = repositoryBook.save(bookDetails);

        //Rest client to send book to kafka
        

        kafkaTemplate.send(TOPIC, book);
        logger.info(String.format("#### -> Producing message -> %s", book));
        return book;
    }
}
