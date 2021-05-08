package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;

@Repository
public interface DogoRepository extends JpaRepository<DogoEntity, Integer> {
}
