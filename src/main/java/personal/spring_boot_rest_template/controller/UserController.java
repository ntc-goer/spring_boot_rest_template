package personal.spring_boot_rest_template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import personal.spring_boot_rest_template.requestdto.CreateUserRequestDto;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;
import personal.spring_boot_rest_template.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getUser(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@Validated @RequestBody CreateUserRequestDto body) {
        UserResponseDto userResponseDto = userService.createOne(body);
        logger.info("personal.spring_boot_rest_template.controller.createUser(): {}", userResponseDto.toString());
        return ResponseEntity.created(URI.create(String.format("/users/%s", userResponseDto.getUserId()))).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
