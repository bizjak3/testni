package si.fri.tpo.pasjehodec.backend.api.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.UserEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.login_register.RegisterDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.user.UserDto;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;
import si.fri.tpo.pasjehodec.backend.services.UserServices;

@RestController
@RequiredArgsConstructor
public class LoginRegisterApi {
    private final UserServices userServices;
    private final UserEntityMapper userEntityMapper;

    @PostMapping("/register/dog-owner")
    @Operation(
            summary = "Registers new dog owner",
            description = "Registers new dog owner or updates service worker with dog owner status type"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User was created or updated",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BadRequest",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Operation not permitted",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            )
    })
    public ResponseEntity<UserDto> registerNewDogOwner(@RequestBody RegisterDto user) throws BadRequestException, ForbiddenOperationException {
        var entity = userEntityMapper.mapUserEntityFromRegisterDto(user);
        entity = userServices.createNewUser(entity, UserType.DOG_OWNER);
        return ResponseEntity.ok(userEntityMapper.mapUserDtoFromEntity(entity));
    }


    @PostMapping("/register/service-worker")
    @Operation(
            summary = "Registers new service worker",
            description = "Registers new service worker or updates dog owner with service owner status type"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User was created or updated",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "BadRequest",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Operation not permitted",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }
            )
    })
    public ResponseEntity<UserDto> registerNewServiceOwner(@RequestBody RegisterDto user) {
        return null;
    }
}
