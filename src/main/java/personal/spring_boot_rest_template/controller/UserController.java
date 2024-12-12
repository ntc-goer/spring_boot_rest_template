package personal.spring_boot_rest_template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;
import personal.spring_boot_rest_template.service.UserService;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return userService.findAll();
    }
}
