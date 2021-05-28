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
}