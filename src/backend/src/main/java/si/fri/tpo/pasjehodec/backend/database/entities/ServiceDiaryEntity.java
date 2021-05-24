package si.fri.tpo.pasjehodec.backend.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_diary")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ServiceDiaryEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private int assess;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private DogoEntity dogo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ServiceEntity service;

    @OneToMany(mappedBy = "serviceDiary", fetch = FetchType.EAGER)
    private Set<LocationEntity> locations;

    @OneToMany(mappedBy = "serviceDiary", fetch = FetchType.EAGER)
    private Set<TransactionEntity> transactions;
}
