package personal.spring_boot_rest_template.responsedto;

import java.time.LocalDateTime;

public class UserResponseDto {
    private Integer userId;
    private String userName;
    private LocalDateTime birthDate;

    public UserResponseDto() {
    }

    public UserResponseDto(Integer userId, String userName, LocalDateTime birthDate) {
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
