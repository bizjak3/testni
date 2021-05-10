package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {

    Optional<ServiceEntity> findByDescription(String description);
}
