package personal.spring_boot_rest_template.requestdto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateUserRequestDto {
    @NotEmpty(message = "Empty userName field")
    private String userName;
    @NotNull
    private LocalDateTime birthDate;

    public CreateUserRequestDto(String userName, LocalDateTime birthDate) {
        this.userName = userName;
        this.birthDate = birthDate;
    }
}
