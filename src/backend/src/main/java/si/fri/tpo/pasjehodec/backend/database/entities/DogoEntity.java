package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;

@Entity
@Table(name="dogo")
@Getter
@Setter
@NoArgsConstructor
public class DogoEntity {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String breed;
    private Integer breedId;

    @ManyToOne
    @JoinColumn
    private UserEntity owner;
}
