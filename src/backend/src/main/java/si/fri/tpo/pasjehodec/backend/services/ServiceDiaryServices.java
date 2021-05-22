package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.ServiceDiaryRepository;

@Service
@RequiredArgsConstructor
public class ServiceDiaryServices {

    private final ServiceDiaryRepository serviceDiaryRepository;

    public ServiceDiaryEntity createNewServiceDiary(ServiceDiaryEntity entity) {
        return serviceDiaryRepository.save(entity);
    }

}
