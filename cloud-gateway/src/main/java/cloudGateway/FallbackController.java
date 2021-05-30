package cloudGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/ratingServiceFallback")
    public String ratingServiceFallbackMethod() {
        return "Rating service is down";
    }

    @GetMapping("/movieServiceFallback")
    public String movieServiceFallbackMethod() {
        return "Movie service is down";
    }

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod() {
        return "User service is down";
    }

}
