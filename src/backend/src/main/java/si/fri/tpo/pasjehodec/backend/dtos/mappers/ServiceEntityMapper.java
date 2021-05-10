package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;

@Service
public class ServiceEntityMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ServiceEntity castFromServiceDtoToServiceEntity(ServiceDto dto) {
        return modelMapper.map(dto, ServiceEntity.class);
    }

    public ServiceDto castFromServiceEntityToServiceDto(ServiceEntity entity) {
        return modelMapper.map(entity, ServiceDto.class);
    }
}
