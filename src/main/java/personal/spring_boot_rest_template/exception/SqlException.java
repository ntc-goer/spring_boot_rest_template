package personal.spring_boot_rest_template.exception;

public class SqlException extends RuntimeException {
    public SqlException(String message) {
        super(message);
    }

    public SqlException(Throwable cause) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String message = "";
        if(stackTrace.length > 1) {
            StackTraceElement caller = stackTrace[2];
            String className = caller.getClassName();
            String method = caller.getMethodName();
            message = String.format("%s.%s", className,method);
        }
        super(message, cause);
    }

    public SqlException(String message, Throwable cause) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if(stackTrace.length > 1) {
            StackTraceElement caller = stackTrace[2];
            String className = caller.getClassName();
            String method = caller.getMethodName();
            message = String.format("%s.%s.%s", className,method, message);
        }
        super(message, cause);
    }
}
