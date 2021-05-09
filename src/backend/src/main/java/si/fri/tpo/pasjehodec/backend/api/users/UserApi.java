package si.fri.tpo.pasjehodec.backend.api.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.UserEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.user.UserDto;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

import java.util.Arrays;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserServices userServices;
    private final UserEntityMapper userEntityMapper;

    @GetMapping("/get-all")
    @Secured({"ADMIN"})
    public ResponseEntity<UserDto[]> getUsers() {
        return ResponseEntity.ok(
                Arrays.stream(userServices.usersOverview())
                        .map(userEntityMapper::mapUserDtoFromEntity)
                        .toArray(UserDto[]::new)
        );
    }



    @PutMapping("/put")
    public ResponseEntity<UserEntity> putUser(@RequestBody UserDto user, @AuthenticationPrincipal UserEntity userEntity) {
        var entity = userEntityMapper.mapUserEntityFromDto(user);
        return ResponseEntity.ok(
                userServices.saveData(entity)
        );
    }
}
