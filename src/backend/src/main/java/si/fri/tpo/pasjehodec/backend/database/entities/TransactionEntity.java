package si.fri.tpo.pasjehodec.backend.database.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime date = LocalDateTime.now();
    private double value;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private PaymentTypeEntity paymentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ServiceDiaryEntity serviceDiary;
}
