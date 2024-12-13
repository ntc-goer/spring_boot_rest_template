package personal.spring_boot_rest_template.exception.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import personal.spring_boot_rest_template.exception.UserException;

@RestControllerAdvice
public class ResponseAdviceException {

    @ExceptionHandler({UserException.class})
    public ResponseEntity<ErrorResponse> handle(UserException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getStatus())
                .body(new ErrorResponse(
                        ex.getErrorCode().name(),
                        ex.getErrorCode().getMessage()
                ));
    }
}
