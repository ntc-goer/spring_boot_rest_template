package personal.spring_boot_rest_template.requestdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class CreateUserRequestDto {
    @NotEmpty(message = "Empty userName field")
    private String userName;
    @NotNull
    private LocalDateTime birthDate;

    public CreateUserRequestDto(String userName, LocalDateTime birthDate) {
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
