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
}
