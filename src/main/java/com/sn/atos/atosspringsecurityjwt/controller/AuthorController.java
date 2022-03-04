package com.sn.atos.atosspringsecurityjwt.controller;

import com.sn.atos.atosspringsecurityjwt.model.Author;
import com.sn.atos.atosspringsecurityjwt.model.Role;
import com.sn.atos.atosspringsecurityjwt.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RolesAllowed(Role.AUTHOR_ADMIN)
    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.create(author);
    }

    @GetMapping
    public Iterable<Author> getAuthors(){
        return authorService.getAuthors();
    }

    //TODO Add delete, update, get {id}, get books
}
