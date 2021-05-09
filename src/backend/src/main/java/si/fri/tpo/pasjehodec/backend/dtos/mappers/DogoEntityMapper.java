package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;

@Service
public class DogoEntityMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public DogoDto castDogoDtoFromEntity(DogoEntity entity) {
        return modelMapper.map(entity, DogoDto.class);
    }

    public DogoEntity castDogoEntityFromDto(DogoDto dto) {
        return modelMapper.map(dto, DogoEntity.class);
    }

}
