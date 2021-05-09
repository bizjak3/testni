package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_diary")
@Getter
@Setter
@NoArgsConstructor
public class ServiceDiaryEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private int assess;
    private String status;

    @ManyToOne
    @JoinColumn
    private DogoEntity dogo;

    @ManyToOne
    @JoinColumn
    private ServiceEntity service;

    @OneToMany(mappedBy = "serviceDiary")
    private List<LocationEntity> locations;

    @OneToMany(mappedBy = "serviceDiary")
    private List<TransactionEntity> transactions;
}
