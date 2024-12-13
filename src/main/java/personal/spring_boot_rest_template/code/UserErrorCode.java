package personal.spring_boot_rest_template.code;

import org.springframework.http.HttpStatus;

public enum UserErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND, "user not found");

    private final HttpStatus status;
    private final String message;

    UserErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
