package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class ServiceLocationDto {
    private Integer id;
    @NotNull(message = "Koordinata ne sme biti prazna")
    private double geoLat;
    @NotNull(message = "Koordinata ne sme biti prazna")
    private double geoLon;
}
