package dev.arif.productservice.exception;

import dev.arif.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {  // This is like interceptor This is sitting between dispatcher and controller
// Moved here and added Controller advices, and it's like global multiple controller can make use of this
// we can move this as project level as well.
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFound(NotFoundException notFoundException)
    {
        return new ResponseEntity(
                new ExceptionDto( HttpStatus.NOT_FOUND,notFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
