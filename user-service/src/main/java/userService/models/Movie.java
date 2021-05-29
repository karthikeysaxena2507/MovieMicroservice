package userService.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Movie {

    private Long id;

    private String title;

    private String description;

    private String genre;

    private List<Review> reviews;

    public Movie() {

    }

    public Movie(Long id, String title, String description, String genre, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
