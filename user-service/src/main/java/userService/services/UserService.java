package userService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import userService.models.Movie;
import userService.models.MovieDetail;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);



    public MovieDetail getMovieDetailsById(Long id) {



        return new MovieDetail();
    }

}
