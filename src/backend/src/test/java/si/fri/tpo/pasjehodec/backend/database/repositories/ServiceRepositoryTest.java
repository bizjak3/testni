package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ServiceRepository serviceRepository;

    @Test
    public void testService() {

        ServiceEntity newExample = createExample();
        testEntityManager.persist(newExample);
        testEntityManager.flush();

        Optional<ServiceEntity> readExample = serviceRepository.findById(newExample.getId());

        

    }


    private ServiceEntity createExample() {

        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Sprehod psa");
        serviceEntity.setDescription("Za vas bom sprehodil psa");
        serviceEntity.setRestrictions("Ne bom sprehajal agresivnih psov");
        serviceEntity.setDateFrom(LocalDateTime.of(2021, 5, 12, 15, 10));
        serviceEntity.setDateTo(LocalDateTime.of(2021, 5, 12, 16, 30));
        return serviceEntity;
    }
}
