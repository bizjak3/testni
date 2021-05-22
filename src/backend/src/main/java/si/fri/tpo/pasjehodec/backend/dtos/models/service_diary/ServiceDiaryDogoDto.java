package si.fri.tpo.pasjehodec.backend.dtos.models.service_diary;

import lombok.Data;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceDiaryEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class ServiceDiaryDogoDto {
    private Integer id;

    private String name;
    private String breed;
    private Integer breedId;
}
