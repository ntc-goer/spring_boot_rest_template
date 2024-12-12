package personal.spring_boot_rest_template.exception;

public class SqlException extends RuntimeException {
    public SqlException(String message) {
        super(message);
    }

    public SqlException(Throwable cause) {
        super(cause);
    }

    public SqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
