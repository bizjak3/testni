package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
//    @Query("select s from ServiceEntity s where s.dateFrom <= :date and s.dateTo >= :date ")
    @Query("select s from ServiceEntity s where s.dateTo >= :date order by s.dateFrom, s.dateTo")
    List<ServiceEntity> findActiveServicesAtDate(LocalDateTime date);

    Optional<ServiceEntity> findByDescription(String description);

    List<ServiceEntity> findByAuthor(UserEntity userEntity);

    @Query("select distinct s from ServiceEntity s, ServiceDiaryEntity sd, DogoEntity d where sd.dogo.owner.id = :id and sd.service.id = s.id")
    List<ServiceEntity> findAllOrderedServices(Integer id);

    @Query("select distinct s from ServiceEntity s, ServiceDiaryEntity sd, DogoEntity d where sd.service.author.id = :id and sd.service.id = s.id and sd.status = 'Narocena storitev'")
    List<ServiceEntity> findAllSelectedServices(Integer id);

    @Query("select distinct u from UserEntity u, ServiceEntity s, ServiceDiaryEntity sd, DogoEntity d where sd.service.author.id = :id and sd.service.id = s.id and sd.status = 'Narocena storitev' and u.id = sd.dogo.owner.id")
    Optional<UserEntity> findPersonWhoOrdered(Integer id);

    @Query("select distinct u from UserEntity u, ServiceDiaryEntity sd where sd.id = :id and sd.dogo.owner.id = u.id")
    Optional<UserEntity> findPerson(Integer id);
}
