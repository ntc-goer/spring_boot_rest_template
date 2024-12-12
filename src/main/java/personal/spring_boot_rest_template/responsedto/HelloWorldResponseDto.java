package personal.spring_boot_rest_template.responsedto;

public class HelloWorldResponseDto {
    private String message;

    public HelloWorldResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
