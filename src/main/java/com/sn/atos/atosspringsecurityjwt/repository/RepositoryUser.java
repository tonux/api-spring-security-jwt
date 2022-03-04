package com.sn.atos.atosspringsecurityjwt.repository;

import com.sn.atos.atosspringsecurityjwt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUser extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
