package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    private final EmailServices emailServices;

    private final BCryptPasswordEncoder bCryptPasswordEncoder; //za kriptiranje gesel

    public UserEntity saveData(UserEntity user, boolean sifrirajGeslo) {
        if(sifrirajGeslo)
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    /**
     * creates new user or if user already exists but is different type it updates
     * @param user to be added in database
     * @param userType type of added user
     * @return created user
     * @throws BadRequestException something wrong, look in response
     * @throws ForbiddenOperationException user exists in database, but passwords doesn't match
     */
    public UserEntity createNewUser(UserEntity user, String userType) throws BadRequestException, ForbiddenOperationException {
        //preveri, če je email veljaven
        if(!emailServices.isEmailValid(user.getEmail()))
            throw new BadRequestException("Epoštni naslov ni pravilne oblike");

        // preveri, če obstaja, če obstaja samo posodobi tip
        var userOptionalFromDatabase = userRepository.findByEmail(user.getEmail());
        //obstaja, posodobi tip
        if(userOptionalFromDatabase.isPresent()) {
            var userEntity = addUserTypeToUser(userOptionalFromDatabase.get(), userType);

            //preveri, če je geslo pravilno
            if(!bCryptPasswordEncoder.matches(user.getPassword(), userEntity.getPassword()))
                throw new ForbiddenOperationException("Uporabnik obstaja v bazi, vendar se gesli ne ujemata");

            return userRepository.save(userEntity);
        } else {
            user = addUserTypeToUser(user, userType);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public UserEntity[] usersOverview() {
        return userRepository.findAll().toArray(UserEntity[]::new);
    }

    private UserEntity addUserTypeToUser(UserEntity entity, String type) {
        if(type.equals(UserType.DOG_OWNER))
            entity.setIsDogOwner(true);
        if(type.equals(UserType.SERVICE_WORKER))
            entity.setIsServiceWorker(true);

        return entity;
    }
}
