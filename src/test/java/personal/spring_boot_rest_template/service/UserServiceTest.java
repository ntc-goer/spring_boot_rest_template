package personal.spring_boot_rest_template.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import personal.spring_boot_rest_template.entity.PostEntity;
import personal.spring_boot_rest_template.entity.UserEntity;
import personal.spring_boot_rest_template.exception.SqlException;
import personal.spring_boot_rest_template.exception.UserException;
import personal.spring_boot_rest_template.repository.PostRepository;
import personal.spring_boot_rest_template.repository.UserRepository;
import personal.spring_boot_rest_template.requestdto.CreatePostRequestDto;
import personal.spring_boot_rest_template.responsedto.PostResponseDto;
import personal.spring_boot_rest_template.service.impl.UserServiceImpl;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PostRepository postRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    private UserEntity user;


    @BeforeEach
    public void setup() {
        user = UserEntity
                .builder()
                .id(1)
                .userName("test userName")
                .birthDate(LocalDateTime.of(2024, 11, 22, 10, 21))
                .build();
    }

    @DisplayName("givenUserObject_whenCreatePost_thenReturnPostResponseDto")
    @Test
    public void giveUserObject_whenCreatePost_thenReturnPostResponseDto() {
        Integer testId = 1;
        String testTitle = "title01";
        String testContent = "content01";

        CreatePostRequestDto testCreatePostRequestDto = new CreatePostRequestDto(testTitle, testContent);
        PostEntity postEntity = new PostEntity(testId, testTitle, testContent);
        PostResponseDto postResponseDto = new PostResponseDto(testId, testTitle, testContent);


        given(modelMapper.map(testCreatePostRequestDto, PostEntity.class)).willReturn(postEntity);
        given(userRepository.findById(1)).willReturn(Optional.ofNullable(user));
        given(postRepository.save(postEntity)).willReturn(null);
        given(modelMapper.map(postEntity, PostResponseDto.class)).willReturn(postResponseDto);

        PostResponseDto resp = userServiceImpl.createPost(1, testCreatePostRequestDto);

        assertNotNull(resp);
        assertEquals(postResponseDto, resp);
    }

    @DisplayName("giveNotFoundUserObject_whenCreatePost_thenThrowNotFoundException")
    @Test
    public void giveNotFoundUserObject_whenCreatePost_thenThrowNotFoundException() {
        Integer testId = 1;
        String testTitle = "title01";
        String testContent = "content01";
        CreatePostRequestDto testCreatePostRequestDto = new CreatePostRequestDto(testTitle, testContent);

        given(userRepository.findById(1)).willReturn(Optional.empty());

        UserException exception = assertThrows(UserException.class,
                () -> userServiceImpl.createPost(1, testCreatePostRequestDto));

        assertEquals("user not found", exception.getErrorCode().getMessage());
        assertEquals("NOT_FOUND", exception.getErrorCode().name());
    }

    @DisplayName("givenUserObject_whenCreatePost_thenReturnPostResponseDto")
    @Test
    public void giveUserObject_whenCreatePost_saveFail_thenThrowSqlException() {
        Integer testId = 1;
        String testTitle = "title01";
        String testContent = "content01";

        CreatePostRequestDto testCreatePostRequestDto = new CreatePostRequestDto(testTitle, testContent);
        PostEntity postEntity = new PostEntity(testId, testTitle, testContent);
        PostResponseDto postResponseDto = new PostResponseDto(testId, testTitle, testContent);


        given(modelMapper.map(testCreatePostRequestDto, PostEntity.class)).willReturn(postEntity);
        given(userRepository.findById(1)).willReturn(Optional.ofNullable(user));
        given(postRepository.save(postEntity)).willThrow(new SqlException("interrupt network"));

        assertThrows(SqlException.class, () -> userServiceImpl.createPost(1, testCreatePostRequestDto));

        SqlException ex = assertThrows(SqlException.class,
                () -> userServiceImpl.createPost(1, testCreatePostRequestDto));
        assertEquals("personal.spring_boot_rest_template.exception.SqlException: interrupt network", ex.getMessage());
    }
}
