package com.sn.atos.atosspringsecurityjwt.service;

import com.sn.atos.atosspringsecurityjwt.model.Book;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class ScheduledBookCreation {

    private final BookService bookService;

    public ScheduledBookCreation(BookService bookService) {
        this.bookService = bookService;
    }


    @Async
    @Scheduled(fixedDelay = 10000)
    public void shceduleCreationBook() {
        System.out.println(" Create Book - "+System.currentTimeMillis()/10000);

        bookService.create(new Book("Un Livre"+System.currentTimeMillis()/10000, "Bla bla"+System.currentTimeMillis()/10000, "fr"));

    }
}
