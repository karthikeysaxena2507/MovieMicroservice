package userService.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieDetail {

    private Long id;

    private String title;

    private String description;

    private String genre;

    private String averageRating;

    private List<Rating> ratings;

    private List<Review> reviews;

    public MovieDetail() {

    }

    public MovieDetail(Long id, String title, String description, String genre, String averageRating, List<Rating> ratings, List<Review> reviews) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.averageRating = averageRating;
        this.ratings = ratings;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
