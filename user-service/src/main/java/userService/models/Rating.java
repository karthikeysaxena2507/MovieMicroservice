package userService.models;

import org.springframework.stereotype.Component;

@Component
public class Rating {

    private Long id;

    private Long rating;

    private Long movieId;

    private String username;

    public Rating() {

    }

    public Rating(Long id, Long rating, Long movieId, String username) {
        this.id = id;
        this.rating = rating;
        this.movieId = movieId;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
