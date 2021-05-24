package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ServiceLocationDto {
    private Integer id;
    @NotNull(message = "Koordinata ne sme biti prazna")
    private double geoLat;
    @NotNull(message = "Koordinata ne sme biti prazna")
    private double geoLon;
}
