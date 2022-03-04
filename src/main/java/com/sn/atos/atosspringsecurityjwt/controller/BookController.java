package com.sn.atos.atosspringsecurityjwt.controller;


import com.sn.atos.atosspringsecurityjwt.model.Book;
import com.sn.atos.atosspringsecurityjwt.model.Role;
import com.sn.atos.atosspringsecurityjwt.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping(path = "api/book")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RolesAllowed(Role.BOOK_ADMIN)
    @GetMapping
    public Iterable<Book> getBooks(){

        return bookService.getBooks();
    }

    @PostMapping
    public Book create(@RequestBody Book request){
        return bookService.create(request);
    }

    //TODO get, update, delete
}
