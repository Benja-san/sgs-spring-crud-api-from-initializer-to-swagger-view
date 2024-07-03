package sgs.support.api.sgs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgs.support.api.sgs.entity.Author;
import sgs.support.api.sgs.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepo;
    
    public Author findOrCreateAuthor(String authorName){

        Optional<Author> author = this.authorRepo.findByName(authorName);
        if(author.isPresent()){

            return author.get();

        } else {
            Author newAuthor = new Author(authorName);
            Author authorToReturn = authorRepo.save(newAuthor);
            return authorToReturn;
        }
    }

}
