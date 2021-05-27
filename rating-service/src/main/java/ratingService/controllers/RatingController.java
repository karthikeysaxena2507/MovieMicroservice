package ratingService.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ratingService.models.Rating;
import ratingService.services.RatingService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    Logger logger = LoggerFactory.getLogger(RatingController.class);

    private final RatingService ratingService;

    @Autowired
    private RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping("/all")
    public ResponseEntity< List<Rating> > getAllRatings() {
        List<Rating> ratings = ratingService.getAllRatings();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity< List<Rating> > getRatingsByMovieId(@PathVariable Long id) {
        List<Rating> ratings = ratingService.getRatingsByMovieId(id);
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity< Rating > getRatingById(@PathVariable Long id) {
        Rating rating = ratingService.getRatingById(id);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity< Rating > addNewRating(@Valid @RequestBody Rating rating) {
        Rating addedRating = ratingService.addRating(rating);
        return new ResponseEntity<>(addedRating, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity< Rating > updateRating(@Valid @RequestBody Rating rating) {
        Rating updatedRating = ratingService.updateRating(rating);
        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRatingById(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return new ResponseEntity<>("SUCCESS: Rating deleted", HttpStatus.OK);
    }

}
