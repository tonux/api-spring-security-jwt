package com.sn.atos.atosspringsecurityjwt.service;


import com.sn.atos.atosspringsecurityjwt.model.Author;
import com.sn.atos.atosspringsecurityjwt.repository.RepositoryAuthor;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private RepositoryAuthor repositoryAuthor;

    public AuthorService(RepositoryAuthor repositoryAuthor) {
        this.repositoryAuthor = repositoryAuthor;
    }

    public Author create(Author authorDetails){

        return repositoryAuthor.save(authorDetails);

    }

    public Iterable<Author> getAuthors(){
        return repositoryAuthor.findAll();
    }
}
