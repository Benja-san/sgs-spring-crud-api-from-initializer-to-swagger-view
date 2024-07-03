package sgs.support.api.sgs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sgs.support.api.sgs.entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    public Optional<Author> findByName(String name);

} 
