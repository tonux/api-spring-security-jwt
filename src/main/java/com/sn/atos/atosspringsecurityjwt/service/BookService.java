package com.sn.atos.atosspringsecurityjwt.service;

import com.sn.atos.atosspringsecurityjwt.model.Book;
import com.sn.atos.atosspringsecurityjwt.repository.RepositoryBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private RepositoryBook repositoryBook;

    public BookService(RepositoryBook repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public Iterable<Book> getBooks(){
        return repositoryBook.findAll();
    }

    public Book create(Book bookDetails){
        Book book = repositoryBook.save(bookDetails);
        return book;
    }
}
