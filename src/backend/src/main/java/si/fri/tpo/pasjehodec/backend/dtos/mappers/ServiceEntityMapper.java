package si.fri.tpo.pasjehodec.backend.dtos.mappers;

import org.apache.commons.collections4.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;

@Service
public class ServiceEntityMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ServiceEntity castFromServiceDtoToServiceEntity(ServiceDto dto) {
        return modelMapper.map(dto, ServiceEntity.class);
    }

    public ServiceDto castFromServiceEntityToServiceDto(ServiceEntity entity) {
        Double average = CollectionUtils.emptyIfNull(entity.getServiceDiaries()).stream()
                .mapToInt(ServiceDiaryEntity::getAssess)
                .average().orElse(-1);

        var dto = modelMapper.map(entity, ServiceDto.class);
        dto.setAverage(average);

        return dto;
    }
}
