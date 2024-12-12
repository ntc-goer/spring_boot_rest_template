package personal.spring_boot_rest_template.service;

import personal.spring_boot_rest_template.exception.SqlException;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll() throws SqlException;
}
