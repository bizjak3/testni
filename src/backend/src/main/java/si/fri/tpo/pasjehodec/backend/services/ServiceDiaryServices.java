package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceDiaryRepository;

@Service
@RequiredArgsConstructor
public class ServiceDiaryServices {

    private final ServiceDiaryRepository serviceDiaryRepository;

    public ServiceDiaryEntity createNewServiceDiary(ServiceDiaryEntity entity, DogoEntity dogoEntity, ServiceEntity serviceEntity) {
        entity.setDogo(dogoEntity);
        entity.setService(serviceEntity);
        entity.setStatus("Narocena storitev");
        return serviceDiaryRepository.save(entity);
    }

    public ServiceDiaryEntity addRating(Integer id, int rating) {
        ServiceDiaryEntity serviceDiaryEntity = serviceDiaryRepository.getOne(id);
        serviceDiaryEntity.setAssess(rating);
        return serviceDiaryEntity;
    }

}
