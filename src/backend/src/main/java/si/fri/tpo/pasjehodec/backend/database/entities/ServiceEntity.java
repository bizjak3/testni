package si.fri.tpo.pasjehodec.backend.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="service")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ServiceEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private String restrictions;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity author;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<LocationEntity> locations;

    @OneToMany(mappedBy = "service", fetch = FetchType.EAGER)
    private Set<ServiceDiaryEntity> serviceDiaries;

    public ServiceEntity(String name, String description, String restrictions, LocalDateTime dateFrom, LocalDateTime dateTo) {
        this.name = name;
        this.description = description;
        this.restrictions = restrictions;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
