package personal.spring_boot_rest_template.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import personal.spring_boot_rest_template.responsedto.HelloWorldResponseDto;

@RestController
public class HelloWorldController {
    private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/{name}")
    public HelloWorldResponseDto helloWorld(@PathVariable String name) {
        logger.info("Hello World : {}", name);
        return new HelloWorldResponseDto(String.format("Hello %s!", name));
    }
}
