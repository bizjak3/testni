package si.fri.tpo.pasjehodec.backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserServices userServices;

    @GetMapping("/get-all")
    public ResponseEntity<UserEntity[]> getUsers() {
        return ResponseEntity.ok(
                userServices.usersOverview()
        );
    }

    @PostMapping("/register/dog-owner")
    public ResponseEntity<UserEntity> registerNewDogOwner(@RequestBody UserEntity user) {
return null;
    }

    @PostMapping("/register/service-worker")
    public ResponseEntity<UserEntity> registerNewServiceOwner(@RequestBody UserEntity user) {
        return null;
    }

    @PutMapping("/put")
    public ResponseEntity<UserEntity> putUser(@RequestBody UserEntity user, @AuthenticationPrincipal UserEntity userEntity) {
        return ResponseEntity.ok(
                userServices.saveData(user)
        );
    }
}
