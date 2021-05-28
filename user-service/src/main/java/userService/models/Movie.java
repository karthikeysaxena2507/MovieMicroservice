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
}
