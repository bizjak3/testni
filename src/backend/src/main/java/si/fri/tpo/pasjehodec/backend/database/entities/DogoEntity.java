package si.fri.tpo.pasjehodec.backend.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="dogo")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class DogoEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String breed;
    private Integer breedId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity owner;

    @OneToMany(mappedBy = "dogo", fetch = FetchType.EAGER)
    private Set<ServiceDiaryEntity> serviceDiaries;
}
