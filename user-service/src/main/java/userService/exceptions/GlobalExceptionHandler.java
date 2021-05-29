package userService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementFoundException.class)
    public Response handleNoSuchElementFoundException(NoSuchElementFoundException exc) {
        ErrorResponse errorResponse = new ErrorResponse("No Such Entity Found", Response.Status.NOT_FOUND.getStatusCode());
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AllUncaughtException.class)
    public Response handleAllUncaughtException(AllUncaughtException exc) {
        ErrorResponse errorResponse = new ErrorResponse("Unknown Error occurred with server", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }

}
