package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.login_register.LoginDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.login_register.RegisterDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.user.UserDto;

import javax.transaction.Transactional;

@Service
public class UserEntityMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public UserEntity mapUserEntityFromLoginDto(LoginDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    public UserEntity mapUserEntityFromRegisterDto(RegisterDto dto) {
        return modelMapper.map(dto, UserEntity.class);
    }

    @Transactional
    public UserDto mapUserDtoFromEntity(UserEntity entity) {
        return modelMapper.map(entity, UserDto.class);
    }

    public UserEntity mapUserEntityFromDto(UserDto entity) {
        return modelMapper.map(entity, UserEntity.class);
    }
}
