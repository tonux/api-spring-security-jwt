package com.sn.atos.atosspringsecurityjwt.repository;

import com.sn.atos.atosspringsecurityjwt.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAuthor extends CrudRepository<Author, Long> {
}
