package personal.spring_boot_rest_template.requestdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreatePostRequestDto {
    @JsonProperty("title")
    @NotNull
    @NotEmpty
    private String title;
    @JsonProperty("content")
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 500)
    private String content;
}
