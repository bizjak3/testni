package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ServiceDto {
    private Integer id;
    @NotNull(message = "Naziv storitve ne sme bit prazen")
    @Length(min = 1, message = "Naziv storitve ne sme bit prazen")
    private String name;
    @Length(min = 1, message = "Opis storitve ne sme bit prazen")
    @NotNull(message = "Opis storitve ne sme bit prazen")
    private String description;
    private String restrictions;
    @NotNull(message = "Začetni datum ne sme biti prazen")
    private LocalDateTime dateFrom;
    @NotNull(message = "Končni datum ne sme biti prazen")
    private LocalDateTime dateTo;
    private ServiceAuthorDto author;

    private List<ServiceLocationDto> locations;
    private List<ServiceServiceDiaryDto> serviceDiaries;
}
