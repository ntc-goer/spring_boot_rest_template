package personal.spring_boot_rest_template.responsedto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

//@JsonIgnoreProperties({"userId", "birthDate"})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDto {
    @JsonProperty("userId")
    private Integer id;
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime birthDate;
}
