package si.fri.tpo.pasjehodec.backend.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserType;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.ServiceEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;
import si.fri.tpo.pasjehodec.backend.exceptions.BadRequestException;
import si.fri.tpo.pasjehodec.backend.exceptions.ForbiddenOperationException;
import si.fri.tpo.pasjehodec.backend.services.ServiceServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services/")
@RequiredArgsConstructor
public class ServicesApi {
    private final ServiceServices serviceServices;
    private final ServiceEntityMapper serviceEntityMapper;

    @PostMapping("add")
    @Secured({UserType.ADMIN, UserType.SERVICE_WORKER})
    @Operation(
            summary = "Create new service"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Service was created",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ServiceDto.class))
                    }
            )
    })
    public ResponseEntity<ServiceDto> postService(@RequestBody @Validated ServiceDto serviceDto,
                                                  @Parameter(hidden = true) @AuthenticationPrincipal UserEntity userEntity
    ) throws BadRequestException, ForbiddenOperationException {
        var entity = serviceEntityMapper.castFromServiceDtoToServiceEntity(serviceDto);
        entity.setAuthor(userEntity);

        entity = serviceServices.addService(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceEntityMapper.castFromServiceEntityToServiceDto(entity));
    }

    @GetMapping("all")
    @Operation(
            summary = "Get list of active services"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List of currently active services",
                    content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ServiceDto.class)))
                    }
            )
    })
    public ResponseEntity<List<ServiceDto>> getAllActiveServices() {
        var data = serviceServices.getAllActiveServices().stream()
                .map(serviceEntityMapper::castFromServiceEntityToServiceDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(data);
    }
}
