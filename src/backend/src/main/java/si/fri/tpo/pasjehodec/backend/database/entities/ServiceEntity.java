package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="service")
@Getter
@Setter
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Integer id;

    String name;
    String description;
    String restrictions;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;

    @ManyToOne
    @JoinColumn
    private UserEntity subscriber;

    @OneToMany(mappedBy = "service")
    List<LocationEntity> locations;

}
