package personal.spring_boot_rest_template.service;

import personal.spring_boot_rest_template.exception.SqlException;
import personal.spring_boot_rest_template.exception.UserException;
import personal.spring_boot_rest_template.requestdto.CreatePostRequestDto;
import personal.spring_boot_rest_template.requestdto.CreateUserRequestDto;
import personal.spring_boot_rest_template.responsedto.PostResponseDto;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll() throws SqlException;

    UserResponseDto findById(Integer id) throws SqlException, UserException;

    UserResponseDto createOne(CreateUserRequestDto requestDto) throws SqlException;

    void deleteById(Integer id) throws SqlException, UserException;

    List<PostResponseDto> findAllPostByUserId(Integer userId) throws SqlException, UserException;

    PostResponseDto createPost(Integer id, CreatePostRequestDto requestDto) throws SqlException, UserException;
}
