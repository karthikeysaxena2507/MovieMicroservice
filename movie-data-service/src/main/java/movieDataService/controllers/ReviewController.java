package movieDataService.controllers;

import movieDataService.exceptions.BusinessException;
import movieDataService.exceptions.ControllerException;
import movieDataService.models.Review;
import movieDataService.services.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.getAllReviews())
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
    }

    /**
     * API TO GET ALL REVIEWS OF A MOVIE
     * @param movieId ID OF THE MOVIE WHOSE REVIEWS ARE ACCESSED
     * @return LIST OF REQUIRED REVIEWS
     */
    @GET
    @Path("/movie/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewsByMovieId(@PathParam("id") Long movieId) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.getReviewsByMovieId(movieId))
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
    }

    /**
     * API TO GET A REVIEW BY ITS ID
     * @param reviewId THE ID OF THE MOVIE REVIEW TO BE ACCESSED
     * @return THE REQUIRED MOVIE REVIEW
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewById(@PathParam("id") Long reviewId) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.getReviewById(reviewId))
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
    }

    /**
     * API TO GET ALL REVIEWS OF A USER
     * @param username THE USERNAME WHOSE REVIEWS ARE ACCESSED
     * @return THE REQUIRED MOVIE REVIEWS
     */
    @GET
    @Path("/user/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReviewsByUsername(@PathParam("username") String username) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.getReviewsByUsername(username))
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
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
    public Response addNewReview(@Valid Review review) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.addNewReview(review))
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
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
    public Response updateReview(@Valid Review review) {
        try {
            return Response
                    .status(Response.Status.OK)
                    .entity(reviewService.updateReview(review))
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
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
            return Response
                    .status(Response.Status.OK)
                    .entity("SUCCESS: REVIEW DELETED SUCCESSFULLY")
                    .build();
        }
        catch(BusinessException exc) {
            logger.error(exc.getErrorMessage());
            ControllerException ex = new ControllerException(exc.getErrorMessage(), exc.getErrorCode());
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
        catch(Exception exc) {
            logger.error(exc.getMessage());
            ControllerException ex = new ControllerException("Some Error Occurred with the server", "610");
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex)
                    .type(MediaType.APPLICATION_JSON_TYPE)
                    .build();
        }
    }

}