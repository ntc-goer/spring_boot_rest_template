package personal.spring_boot_rest_template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import personal.spring_boot_rest_template.requestdto.CreatePostRequestDto;
import personal.spring_boot_rest_template.requestdto.CreateUserRequestDto;
import personal.spring_boot_rest_template.responsedto.PostResponseDto;
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
        return ResponseEntity.created(URI.create(String.format("/users/%s", userResponseDto.getId()))).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<PostResponseDto> getPosts(@PathVariable Integer id) {
        return userService.findAllPostByUserId(id);
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<PostResponseDto> createPost(@PathVariable Integer id, @Validated @RequestBody CreatePostRequestDto body){
        PostResponseDto responseDto =  userService.createPost(id, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
