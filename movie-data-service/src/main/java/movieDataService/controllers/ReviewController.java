package movieDataService.controllers;

import movieDataService.models.Review;
import movieDataService.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Controller
@Path("/api/reviews")
public class ReviewController {

    Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewService reviewService;

    /**
     * API TO GET ALL REVIEWS
     * @return LIST OF ALL REVIEWS
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReviews() {
        try {
            List<Review> reviews = new ArrayList<>();
            reviews = reviewService.getAllReviews();
            return Response.status(200).entity(reviews).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TE GET ALL REVIEWS OF A MOVIE
     * @param movieId ID OF THE MOVIE WHOSE REVIEWS ARE ACCESSED
     * @return LIST OF REQUIRED REVIEWS
     */
    @GET
    @Path("/movie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewsByMovieId(@PathParam("id") Long movieId) {
        try {
            List<Review> reviews = new ArrayList<>();
            reviews = reviewService.getReviewsByMovieId(movieId);
            return Response.status(200).entity(reviews).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TE GET A REVIEW BY ITS ID
     * @param reviewId THE ID OF THE MOVIE REVIEW TO BE ACCESSED
     * @return THE REQUIRED MOVIE REVIEW
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewById(@PathParam("id") Long reviewId) {
        try {
            Review review = reviewService.getReviewById(reviewId);
            return Response.status(200).entity(review).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO ADD A NEW REVIEW TO A MOVIE
     * @return THE NEWLY ADDED REVIEW
     */
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewReview(Review review) {
        try {
            Review addedReview = reviewService.addNewReview(review);
            return Response.status(200).entity(addedReview).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO UPDATE A MOVIE REVIEW
     * @param review THE NEW MOVIE REVIEW DATA
     * @return THE UPDATED MOVIE REVIEW
     */
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateReview(Review review) {
        try {
            Review updatedReview = reviewService.updateReview(review);
            return Response.status(200).entity(updatedReview).build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    /**
     * API TO DELETE A MOVIE REVIEW
     * @param id THE ID OF THE REVIEW TO BE DELETED
     * @return SUCCESS MESSAGE ON DELETION
     */
    @DELETE
    @Path("/delete/{id}")
    public Response deleteReview(@PathParam("id") Long id) {
        try {
            reviewService.deleteReview(id);
            return Response.status(200).entity("SUCCESS: REVIEW DELETED SUCCESSFULLY").build();
        }
        catch(Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}