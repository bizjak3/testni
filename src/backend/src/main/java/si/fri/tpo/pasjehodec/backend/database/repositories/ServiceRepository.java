package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
    @Query("select s from ServiceEntity s where s.dateFrom <= :date and s.dateTo >= :date ")
    List<ServiceEntity> findActiveServicesAtDate(LocalDateTime date);

    Optional<ServiceEntity> findByDescription(String description);
}
