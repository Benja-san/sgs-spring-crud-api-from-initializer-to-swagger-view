package sgs.support.api.sgs.dto;

public class BookWithoutAuthor {
    
    private Long id;
    private String name;
    private String cover;
    private String synopsis;

    public BookWithoutAuthor(Long id, String name, String cover, String synopsis) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.synopsis = synopsis;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSynopsis() {
        return this.synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

}
