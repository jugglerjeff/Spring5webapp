package com.example.Spring5webapp.bootstrap;

import com.example.Spring5webapp.model.Author;
import com.example.Spring5webapp.model.Book;
import com.example.Spring5webapp.model.Publisher;
import com.example.Spring5webapp.repositories.AuthorRepository;
import com.example.Spring5webapp.repositories.BookRepository;
import com.example.Spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //create publishers
        Publisher hc =new Publisher("Harper Collins", "1000 Collins Drive", "", "Collins", "TX", "43526");
        Publisher worx =new Publisher("Worx", "1000 Worx Drive", "", "Worx", "AL", "73526");

        publisherRepository.save(hc);
        publisherRepository.save(worx);

        //create author and book test data
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
