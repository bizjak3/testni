package si.fri.tpo.pasjehodec.backend.security;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImplementation implements UserDetailsService {

    private final UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserEntity loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s)
                .orElseThrow(() -> new ForbiddenOperationException("Uporabnik s podanim uporabniškim imenom ne obstaja"));
    }
}
