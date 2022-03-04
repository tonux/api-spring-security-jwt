package com.sn.atos.atosspringsecurityjwt.dbInit;

import com.sn.atos.atosspringsecurityjwt.model.Author;
import com.sn.atos.atosspringsecurityjwt.model.Book;
import com.sn.atos.atosspringsecurityjwt.model.Role;
import com.sn.atos.atosspringsecurityjwt.model.User;
import com.sn.atos.atosspringsecurityjwt.service.AuthorService;
import com.sn.atos.atosspringsecurityjwt.service.BookService;
import com.sn.atos.atosspringsecurityjwt.service.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DatabaseInit implements ApplicationListener<ApplicationReadyEvent> {

    private final BookService bookService;
    private final AuthorService authorService;
    private final UserService userService;


    public DatabaseInit(BookService bookService, AuthorService authorService,  UserService userService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // Create Book
        bookService.create(new Book("Une si longue lettre", "Bla bla", "fr"));
        bookService.create(new Book("Pere Gorio", "Bla bla", "fr"));

        // Create Author
        authorService.create(new Author("Mariama Ba", "Senegalaise", "Sn"));
        authorService.create(new Author("Emile Zola", "Auteur Francais", "Fr"));

        try{
            // Create User
            userService.create(new User("barry@atos.sn", "Passer@123", "Mamadou Barry", Set.of(new Role(Role.BOOK_ADMIN)) ));
            userService.create(new User("katy@atos.sn", "Passer@123", "Yaye Katy", Set.of(new Role(Role.USER_ADMIN)) ));

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
