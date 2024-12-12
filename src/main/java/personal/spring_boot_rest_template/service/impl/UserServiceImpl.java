package personal.spring_boot_rest_template.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import personal.spring_boot_rest_template.entity.UserEntity;
import personal.spring_boot_rest_template.exception.SqlException;
import personal.spring_boot_rest_template.repository.UserRepository;
import personal.spring_boot_rest_template.responsedto.UserResponseDto;
import personal.spring_boot_rest_template.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserResponseDto> findAll() throws SqlException {
        try {
            List<UserEntity> items =  userRepository.findAll();
            this.modelMapper.typeMap(UserEntity.class, UserResponseDto.class).addMapping(
                    UserEntity::getId, UserResponseDto::setUserId
            );
            return this.modelMapper.map(items, new TypeToken<List<UserResponseDto>>() {}.getType());
        } catch (Exception ex){
            throw new SqlException("personal.spring_boot_rest_template.service.impl.findAll", ex);
        }
    }
}