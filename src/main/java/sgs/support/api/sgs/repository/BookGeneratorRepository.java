package sgs.support.api.sgs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;

import sgs.support.api.sgs.entity.Book;

@Component
public class BookGeneratorRepository implements CommandLineRunner {

    
    private Faker faker = new Faker();
    private Slugify slugify = Slugify.builder().build();
    
    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) {

        if(bookRepo.count() == 0){

            List<Book> books = new ArrayList<>();

            for(int i=0; i < 10; i++){
                Book book = new Book();
                book.setName(faker.book().title());
                book.setAuthor(faker.book().author());
                book.setSlug(slugify.slugify(book.getName()));
                book.setSynopsis("I just wanna die! Don't Morty me! I tricked Rick into taking Dad on an adventure because I thought I could get a break from this kind of shit! But no! Like father, like goddamn daughter! You wanna be like Rick?! Congratulations! You're just as arrogant and just as irresponsible! Yeah, those two were fucking. Go home and drink, grandpa.");
                book.setCover("https://cdn1.booknode.com/book_cover/1235/les_annales_du_disque_monde_tome_1_la_huitieme_couleur-1235330-264-432.jpg");

                books.add(book);
            }

            this.bookRepo.saveAll(books);

        }

    }
    
}
