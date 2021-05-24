package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.DogoRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceDiaryRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.DataNotFoundException;

@Service
@RequiredArgsConstructor
public class ServiceDiaryServices {

    private final ServiceDiaryRepository serviceDiaryRepository;
    private final DogoRepository dogoRepository;
    private final ServiceRepository serviceRepository;

    public ServiceDiaryEntity createNewServiceDiary(ServiceDiaryEntity entity, Integer dogoId, Integer serviceId) {
        entity.setDogo(dogoRepository.getOne(dogoId));
        entity.setService(serviceRepository.getOne(serviceId));
        entity.setStatus("Narocena storitev");
        return serviceDiaryRepository.save(entity);
    }

    public ServiceDiaryEntity addRating(Integer id, int rating, UserEntity userEntity) throws DataNotFoundException {
        var serviceDiaryEntity = serviceRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Servis ne obstaja"))
                .getServiceDiaries().stream()
                .filter(e -> e.getDogo().getOwner().getId().equals(userEntity.getId()))
                .findAny().orElseThrow(() -> new DataNotFoundException("Zapis ne obstaja"));

        serviceDiaryEntity.setAssess(rating);
        return serviceDiaryRepository.save(serviceDiaryEntity);
    }

}
