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

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ServiceRepository serviceRepository;

    // v bazo zapise novo storitev, poiscemo iz baze po id-ju, ter primerjamo ce sta enaka

    @Test
    public void testService1() {

        ServiceEntity newExample = new ServiceEntity("x", "Sprehod vasega psa po Tivoliju", "y", LocalDateTime.of(2021, 5, 12, 15, 10), LocalDateTime.of(2021, 5, 12, 16, 10));

        // ServiceEntity newExample = createExample();
        testEntityManager.persist(newExample);
        testEntityManager.flush();

        Optional<ServiceEntity> readExample = serviceRepository.findById(newExample.getId());

        assertThat(readExample.get().getDescription())
                .isEqualTo(newExample.getDescription());

    }

    // v bazo zapisemo novo storitev, poiscemo iz baze po id-ju, ter primerjamo ce je description "Sprehod vasega psa po Tivoliju"

    @Test
    public void testService2() {
        ServiceEntity newExample = new ServiceEntity("x", "Sprehod vasega psa po Tivoliju", "y", LocalDateTime.of(2021, 5, 12, 15, 10), LocalDateTime.of(2021, 5, 12, 16, 10));

        // ServiceEntity newExample = createExample();
        testEntityManager.persist(newExample);
        testEntityManager.flush();

        Optional<ServiceEntity> readExample = serviceRepository.findById(newExample.getId());

        assertThat(readExample.get().getDescription())
                .isEqualTo("Sprehod vasega psa po Tivoliju");
    }

    // v bazo zapisemo novo storitev, poiscemo iz baze po opisu s funkcijo findByDescription, ter primerjamo ce sta enaka

    @Test
    public void testService3() {
        ServiceEntity newExample = new ServiceEntity("x", "Sprehod vasega psa po Tivoliju", "y", LocalDateTime.of(2021, 5, 12, 15, 10), LocalDateTime.of(2021, 5, 12, 16, 10));

        // ServiceEntity newExample = createExample();
        testEntityManager.persist(newExample);
        testEntityManager.flush();

        Optional<ServiceEntity> readExample = serviceRepository.findByDescription("Sprehod vasega psa po Tivoliju");

        assertThat(readExample.get().getDescription())
                .isEqualTo(newExample.getDescription());
    }

    private ServiceEntity createExample() {

        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(1);
        serviceEntity.setName("Sprehod psa");
        serviceEntity.setDescription("Za vas bom sprehodil psa");
        serviceEntity.setRestrictions("Ne bom sprehajal agresivnih psov");
        serviceEntity.setDateFrom(LocalDateTime.of(2021, 5, 12, 15, 10));
        serviceEntity.setDateTo(LocalDateTime.of(2021, 5, 12, 16, 30));
        return serviceEntity;
    }
}
