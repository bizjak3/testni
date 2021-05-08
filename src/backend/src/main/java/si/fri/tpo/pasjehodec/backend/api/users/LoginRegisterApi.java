package si.fri.tpo.pasjehodec.backend.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

@RestController
@RequiredArgsConstructor
public class LoginRegisterApi {
    private final UserServices userServices;

    @PostMapping("/register/dog-owner")
    public ResponseEntity<UserEntity> registerNewDogOwner(@RequestBody UserEntity user) throws BadRequestException, ForbiddenOperationException {
        return ResponseEntity.ok(userServices.createNewUser(user, UserType.DOG_OWNER));
    }

    @PostMapping("/register/service-worker")
    public ResponseEntity<UserEntity> registerNewServiceOwner(@RequestBody UserEntity user) {
        return null;
    }
}
