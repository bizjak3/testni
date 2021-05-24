package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.MessageDto;

@Service
public class MessageEntityMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public MessageEntity castFromMessageDtoToMessageEntity(MessageDto dto) {
        return modelMapper.map(dto, MessageEntity.class);
    }

    public MessageDto castFromMessageEntityToMessageDto(MessageEntity entity) {
        return modelMapper.map(entity, MessageDto.class);
    }
}
