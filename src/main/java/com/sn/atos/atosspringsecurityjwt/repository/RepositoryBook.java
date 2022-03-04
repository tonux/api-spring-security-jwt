package com.sn.atos.atosspringsecurityjwt.repository;

import com.sn.atos.atosspringsecurityjwt.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook  extends CrudRepository<Book, Long> {
}
