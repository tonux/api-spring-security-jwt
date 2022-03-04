package com.sn.atos.atosspringsecurityjwt.service;

import com.sn.atos.atosspringsecurityjwt.model.Role;
import com.sn.atos.atosspringsecurityjwt.model.User;
import com.sn.atos.atosspringsecurityjwt.repository.RepositoryUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.Set;

@Service
public class UserService {

    private final RepositoryUser repositoryUser;
    private final PasswordEncoder passwordEncoder;

    public UserService(RepositoryUser repositoryUser, PasswordEncoder passwordEncoder) {
        this.repositoryUser = repositoryUser;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User request) throws ValidationException {
        if (repositoryUser.findByUsername(request.getUsername()).isPresent()){
            throw new ValidationException("User exists!");
        }

        // if password != confirm password throw exception

        if(request.getAuthorities() == null){
            request.setAuthorities(Set.of(new Role(Role.USER_ADMIN)));
        }

        User user = request;

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return repositoryUser.save(user);

    }
}
