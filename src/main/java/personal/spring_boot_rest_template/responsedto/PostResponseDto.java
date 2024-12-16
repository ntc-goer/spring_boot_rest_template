package personal.spring_boot_rest_template.responsedto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDto {
    @JsonProperty("postId")
    public Integer id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("content")
    public String content;
}
