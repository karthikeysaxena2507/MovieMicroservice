package userService.models;

import org.springframework.stereotype.Component;

@Component
public class Review {

    private Long id;

    private String username;

    private String content;

    private Long movieId;

    public Review() {

    }

    public Review(Long id, String username, String content, Long movieId) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}