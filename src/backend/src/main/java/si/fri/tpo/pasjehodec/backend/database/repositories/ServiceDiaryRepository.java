package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import java.util.Optional;

@Repository
public interface ServiceDiaryRepository extends JpaRepository<ServiceDiaryEntity, Integer> {

    @Query("select distinct sd from ServiceDiaryEntity sd where sd.service.id = :id")
    Optional<ServiceDiaryEntity> getSDbyService(Integer id);
}
