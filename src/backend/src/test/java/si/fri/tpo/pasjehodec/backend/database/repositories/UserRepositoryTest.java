package si.fri.tpo.pasjehodec.backend.database.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;


    // preveri ce se user pravilno zapise v bazo, primerja imeni
    @Test
    public void testUser1() {

        UserEntity newUser = new UserEntity("Janez", "Novak", "jnovak@gmail.com", "janezN");

        testEntityManager.persist(newUser);
        testEntityManager.flush();

        Optional<UserEntity> readNewUser = userRepository.findById(newUser.getId());

        assertThat(readNewUser.get().getName())
                .isEqualTo(newUser.getName());
    }


    // preveri ce obstaja uporabnik z emailom jnovak@gmail.com
    @Test
    public void testUser2() {

        UserEntity newUser = new UserEntity("Janez", "Novak", "jnovak@gmail.com", "janezN");

        testEntityManager.persist(newUser);
        testEntityManager.flush();

        Optional<UserEntity> readNewUser = userRepository.findByEmail("jnovak@gmail.com");

        assertThat(readNewUser.get().getEmail())
                .isEqualTo(newUser.getEmail());
    }

    // preveri ce obstaja uporabnik z usernamom janezN
    @Test
    public void testUser3() {

        UserEntity newUser = new UserEntity("Janez", "Novak", "jnovak@gmail.com", "janezN");

        testEntityManager.persist(newUser);
        testEntityManager.flush();

        Optional<UserEntity> readNewUser = userRepository.findByUsername("janezN");

        assertThat(readNewUser.get().getId())
                .isEqualTo(newUser.getId());
    }

}
