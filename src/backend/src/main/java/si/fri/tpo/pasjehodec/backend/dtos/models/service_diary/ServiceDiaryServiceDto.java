package si.fri.tpo.pasjehodec.backend.dtos.models.service_diary;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServiceDiaryServiceDto {
    private Integer id;

    private String name;
    private String description;
    private String restrictions;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
}
