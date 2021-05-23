package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.DogoRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class DogoService {
    private final DogoRepository dogoRepository;
    private final UserServices userServices;
    private final UserRepository userRepository;

    public DogoEntity addDogo(DogoEntity dogo, UserEntity lastnik) {
        if(lastnik.getId() == null) {
            lastnik = userServices.updateUserMe(lastnik, true);
        } else {
            lastnik = userRepository.getOne(lastnik.getId());
        }

        dogo.setOwner(lastnik);
        return dogoRepository.save(dogo);
    }
}
