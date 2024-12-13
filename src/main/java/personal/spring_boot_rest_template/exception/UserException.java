package personal.spring_boot_rest_template.exception;

import personal.spring_boot_rest_template.code.UserErrorCode;

public class UserException extends RuntimeException {
    final private UserErrorCode errorCode;

    public UserException(UserErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public UserErrorCode getErrorCode() {
        return errorCode;
    }
}
