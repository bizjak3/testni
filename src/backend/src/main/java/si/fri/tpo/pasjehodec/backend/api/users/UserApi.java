package si.fri.tpo.pasjehodec.backend.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserServices userServices;

    @GetMapping("/get-all")
    @Secured({"ADMIN"})
    public ResponseEntity<UserEntity[]> getUsers() {
        return ResponseEntity.ok(
                userServices.usersOverview()
        );
    }



    @PutMapping("/put")
    public ResponseEntity<UserEntity> putUser(@RequestBody UserEntity user, @AuthenticationPrincipal UserEntity userEntity) {
        return ResponseEntity.ok(
                userServices.saveData(user)
        );
    }
}
