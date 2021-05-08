package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServices{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntity saveData(UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserEntity createNewUser(UserEntity user, UserType userType) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUsertype(userType);

        return userRepository.save(user);
    }

    public UserEntity[] usersOverview() {
        return userRepository.findAll().toArray(UserEntity[]::new);
    }
}
