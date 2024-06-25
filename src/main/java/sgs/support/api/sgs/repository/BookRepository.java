package sgs.support.api.sgs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgs.support.api.sgs.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    public List<Book> findAllByOrderByNameAsc();

    public Optional<Book> findBySlug(String slug);

}
