package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.service_diary.ServiceDiaryDto;

@Service
public class ServiceDiaryEntityMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ServiceDiaryDto castFromServiceDiaryEntityToServiceDiaryDto(ServiceDiaryEntity entity) {
        return modelMapper.map(entity, ServiceDiaryDto.class);
    }

    public ServiceDiaryEntity castFromServiceDiaryDtoToServiceDiaryEntity(ServiceDiaryDto dto) {
        return modelMapper.map(dto, ServiceDiaryEntity.class);
    }
}
