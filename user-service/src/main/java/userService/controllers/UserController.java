package userService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import userService.exceptions.NoSuchElementFoundException;
import userService.models.Movie;
import userService.models.MovieDetail;
import userService.models.Rating;
import userService.models.Review;
import userService.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@Path("/api/users")
public class UserController {

    private final UserService userService;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("/review/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewDetailsByReviewId(@PathParam("id") Long id) {
        logger.info("Review Id => " + id);
        Review reviewDetails = userService.getReviewDetailsByReviewId(id);
        return Response
                .status(Response.Status.OK)
                .entity(reviewDetails)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/ratings/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRatingsByMovieId(@PathParam("id") Long id) {
        logger.info("Movie Id => " + id);
        List<Rating> ratings = userService.getRatingsByMovieId(id);
        return Response
                .status(Response.Status.OK)
                .entity(ratings)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/reviews")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        List<Review> reviews = userService.getAllReviews();
        return Response
                .status(Response.Status.OK)
                .entity(reviews)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/ratings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRatings() {
        List<Review> ratings = userService.getAllReviews();
        return Response
                .status(Response.Status.OK)
                .entity(ratings)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/movie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieDetailsById(@PathParam("id") Long id) {
        Movie movie = userService.getMovieDetails(id);
        return Response
                .status(Response.Status.OK)
                .entity(movie)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @GET
    @Path("/movie/all/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovieDetailsById(@PathParam("id") Long id) {
        MovieDetail movieDetails = userService.getAllMovieDetails(id);
        return Response
                .status(Response.Status.OK)
                .entity(movieDetails)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
