package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;

@Data
public class ServiceServiceDiaryDto {
    private Integer id;
    private int assess;
    private String status;
    private DogoDto dogo;
}
