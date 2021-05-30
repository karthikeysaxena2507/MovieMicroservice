package ratingService.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false)
    @Min(1)
    @Max(10)
    @NotNull
    private Long rating;

    @Column(nullable = false)
    @NotNull
    private Long movieId;

    @Column(nullable = false)
    @NotNull
    private String username;

    public Rating() {

    }

    public Rating(Long rating, Long movieId, String username) {
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
