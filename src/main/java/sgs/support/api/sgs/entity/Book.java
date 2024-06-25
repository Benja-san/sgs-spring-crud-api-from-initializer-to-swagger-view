package sgs.support.api.sgs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 100, message = "Book name has to be between 2 and 100 characters")
    private String name;
    private String slug;
    private String author;
    @Column(columnDefinition ="TEXT")
    private String Synopsis;
    private String cover;

    public Book() {}

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(String name, String slug, String author, String Synopsis, String cover) {
        this.name = name;
        this.author = author;
        this.Synopsis = Synopsis;
        this.cover = cover;
    }
    


    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSynopsis() {
        return this.Synopsis;
    }

    public void setSynopsis(String Synopsis) {
        this.Synopsis = Synopsis;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    
}
