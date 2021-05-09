package si.fri.tpo.pasjehodec.backend.database.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="payment_type")
@Getter
@Setter
@NoArgsConstructor
public class PaymentTypeEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String cardNumber;
    private String cw;
    private LocalDateTime expirationDate;
    private boolean defaultPaymentType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private UserEntity cardOwner;

    @OneToMany(mappedBy = "paymentType")
    private List<TransactionEntity> transactions;
}
