package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.LocationEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.TransactionEntity;
import si.fri.tpo.pasjehodec.backend.dtos.models.dogo.DogoDto;

import javax.persistence.*;
import java.util.Set;

@Data
public class ServiceServiceDiaryDto {
    private Integer id;
    private int assess;
    private String status;
    private DogoDto dogo;
}
