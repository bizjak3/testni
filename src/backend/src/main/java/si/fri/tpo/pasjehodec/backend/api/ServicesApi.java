package si.fri.tpo.pasjehodec.backend.api;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.ServiceEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;
import si.fri.tpo.pasjehodec.backend.services.ServiceServices;

@RestController
@RequestMapping("/services/")
@RequiredArgsConstructor
public class ServicesApi {
    private final ServiceServices serviceServices;
    private final ServiceEntityMapper serviceEntityMapper;

    @PostMapping("add")
    @Secured({UserType.ADMIN, UserType.SERVICE_WORKER})
    public ResponseEntity<ServiceDto> postService(@RequestBody @Validated ServiceDto serviceDto,
                                                  @Parameter(hidden = true) @AuthenticationPrincipal UserEntity userEntity
    ) throws BadRequestException, ForbiddenOperationException {
        var entity = serviceEntityMapper.castFromServiceDtoToServiceEntity(serviceDto);
        entity.setAuthor(userEntity);

        entity = serviceServices.addService(entity);
        return ResponseEntity.ok(serviceEntityMapper.castFromServiceEntityToServiceDto(entity));
    }
}
