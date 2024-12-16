package personal.spring_boot_rest_template.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import personal.spring_boot_rest_template.code.UserErrorCode;
import personal.spring_boot_rest_template.entity.PostEntity;
import personal.spring_boot_rest_template.entity.UserEntity;
import personal.spring_boot_rest_template.exception.SqlException;
import personal.spring_boot_rest_template.exception.UserException;
import personal.spring_boot_rest_template.repository.PostRepository;
import personal.spring_boot_rest_template.repository.UserRepository;
import personal.spring_boot_rest_template.requestdto.CreatePostRequestDto;
import personal.spring_boot_rest_template.requestdto.CreateUserRequestDto;
import personal.spring_boot_rest_template.responsedto.PostResponseDto;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;
import personal.spring_boot_rest_template.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public List<UserResponseDto> findAll() throws SqlException {
        try {
            List<UserEntity> items = this.userRepository.findAll();
            return this.modelMapper.map(items, new TypeToken<List<UserResponseDto>>() {
            }.getType());
        } catch (Exception ex) {
            throw new SqlException(ex);
        }
    }

    @Override
    @Transactional
    public UserResponseDto findById(Integer id) throws SqlException, UserException {
        try {
            UserEntity userEntity = this.userRepository
                    .findById(id)
                    .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));
            return this.modelMapper.map(userEntity, UserResponseDto.class);
        } catch (Exception ex) {
            throw new SqlException(ex);
        }
    }

    @Override
    @Transactional
    public UserResponseDto createOne(CreateUserRequestDto requestDto) throws SqlException {
        try {
            UserEntity userEntity = new UserEntity(requestDto.getUserName(), requestDto.getBirthDate());
            this.userRepository.save(userEntity);
            return this.modelMapper.map(userEntity, UserResponseDto.class);
        } catch (Exception e) {
            throw new SqlException(e);
        }
    }

    @Override
    @Transactional
    public void deleteById(Integer id) throws SqlException, UserException {
        try {
            this.userRepository
                    .findById(id)
                    .orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));
            this.userRepository.deleteById(id);
        } catch (Exception ex) {
            throw new SqlException(ex);
        }
    }

    @Override
    @Transactional
    public List<PostResponseDto> findAllPostByUserId(Integer userId) throws SqlException, UserException {
        try {
            UserEntity user = userRepository.findById(userId).orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));
            return this.modelMapper.map(user.getPosts(), new TypeToken<List<PostResponseDto>>() {
            }.getType());
        } catch (Exception ex) {
            throw new SqlException(ex);
        }
    }

    @Override
    @Transactional
    public PostResponseDto createPost(Integer id, CreatePostRequestDto requestDto) throws SqlException, UserException {
        try {
            UserEntity userEntity = this.userRepository.findById(id).orElseThrow(() -> new UserException(UserErrorCode.NOT_FOUND));
            PostEntity postEntity = this.modelMapper.map(requestDto, PostEntity.class);
            postEntity.setUser(userEntity);
            this.postRepository.save(postEntity);
            return this.modelMapper.map(postEntity, PostResponseDto.class);
        } catch (Exception ex) {
            throw new SqlException(ex);
        }
    }
}
