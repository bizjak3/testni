package si.fri.tpo.pasjehodec.backend.database.entities;

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
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime date;
    private double value;
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private PaymentTypeEntity paymentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ServiceDiaryEntity serviceDiary;
}
