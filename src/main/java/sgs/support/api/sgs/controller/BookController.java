package sgs.support.api.sgs.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.slugify.Slugify;
import sgs.support.api.sgs.entity.Book;
import sgs.support.api.sgs.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    private Slugify slugify = Slugify.builder().build();

    @Autowired
    BookRepository bookRepo;

    @GetMapping("")
    public List<Book> getAll() {
        List<Book> books = this.bookRepo.findAllByOrderByNameAsc(); 
        return books;
    }

    @GetMapping("/{id}")
    public Book getOneById(@PathVariable Long id) {
        Book book = this.bookRepo.findById(id).get();
        return book;
    }

    @GetMapping("/title/{slug}")
    public Book getOneBySlug(@PathVariable String slug) {
        Optional<Book> book = this.bookRepo.findBySlug(slug);
        if(book.isPresent()) {
            return book.get();
        }
        throw new Error();
    }

    @PostMapping("")
    public Book addOne(@RequestBody Book book){
        book.setSlug(slugify.slugify(book.getName()));
        return this.bookRepo.save(book);
    }

    @PutMapping("/{id}")
    public Book updateOne(@PathVariable Long id, @RequestBody Book book){

        Book retrievedBook = this.bookRepo.findById(id).get();
        retrievedBook.setName(book.getName());
        retrievedBook.setSlug(slugify.slugify(book.getName()));
        retrievedBook.setAuthor(book.getAuthor());
        retrievedBook.setCover(book.getCover());
        retrievedBook.setSynopsis(book.getSynopsis());
        
        return this.bookRepo.save(retrievedBook);

    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable Long id){
        this.bookRepo.deleteById(id);
    }
}
