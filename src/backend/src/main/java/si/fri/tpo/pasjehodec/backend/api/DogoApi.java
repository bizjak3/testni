package si.fri.tpo.pasjehodec.backend.api;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.DogoEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;
import si.fri.tpo.pasjehodec.backend.services.DogoService;

import java.util.Arrays;

@RestController
@RequestMapping("/dogos/")
@RequiredArgsConstructor
public class DogoApi {

    private final DogoService dogoService;
    private final DogoEntityMapper dogoEntityMapper;

    @PostMapping("post")
    @Secured({
            UserType.DOG_OWNER,
            UserType.ADMIN
    })
    public ResponseEntity<DogoDto> postDogo(@RequestBody DogoDto dogo, @Parameter(hidden = true) @AuthenticationPrincipal UserEntity user) {
        var entity = dogoEntityMapper.castDogoEntityFromDto(dogo);
        entity = dogoService.addDogo(entity, user);
        return ResponseEntity.ok(dogoEntityMapper.castDogoDtoFromEntity(entity));
    }

    @GetMapping("get-users-dogos")
    public ResponseEntity<DogoDto[]> getUsersDogos(@AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.ok(
                dogoService.getUsersDogos(user).stream()
                .map(dogoEntityMapper::castDogoDtoFromEntity)
                .toArray(DogoDto[]::new)
        );
    }

    @GetMapping("location")
    public ResponseEntity<DogoDto> getDogoLocation(@Parameter DogoEntity dogoEntity) {
        return ResponseEntity.ok(dogoEntityMapper.castDogoDtoFromEntity(dogoEntity));
    }
}
