package si.fri.tpo.pasjehodec.backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.DogoEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;
import si.fri.tpo.pasjehodec.backend.services.DogoService;

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
    public ResponseEntity<DogoDto> postDogo(@RequestBody DogoDto dogo, @AuthenticationPrincipal UserEntity user) {
        var entity = dogoEntityMapper.castDogoEntityFromDto(dogo);
        entity = dogoService.addDogo(entity, entity.getOwner());
        return ResponseEntity.ok(dogoEntityMapper.castDogoDtoFromEntity(entity));
    }
}
