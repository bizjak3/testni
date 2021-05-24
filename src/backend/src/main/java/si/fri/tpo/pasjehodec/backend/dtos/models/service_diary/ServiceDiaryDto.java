package si.fri.tpo.pasjehodec.backend.dtos.models.service_diary;

import lombok.Data;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.service.ServiceDto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class ServiceDiaryDto {
    private Integer id;

    @Min(1)
    @Max(5)
    private int assess;

    private String status;

    private DogoDto dogo;
    private ServiceDto service;

//    private Set<LocationEntity> locations;
//
//    private Set<TransactionEntity> transactions;
}
