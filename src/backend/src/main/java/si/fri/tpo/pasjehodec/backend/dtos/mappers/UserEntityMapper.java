package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.LoginDto;

@Service
public class UserEntityMapper {

    public static UserEntity mapUserEntityFromLoginDto(LoginDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, UserEntity.class);
    }
}
