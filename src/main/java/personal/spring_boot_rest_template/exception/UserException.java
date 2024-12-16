package personal.spring_boot_rest_template.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import personal.spring_boot_rest_template.code.UserErrorCode;

@Getter
@AllArgsConstructor
public class UserException extends RuntimeException {
    final private UserErrorCode errorCode;
}
