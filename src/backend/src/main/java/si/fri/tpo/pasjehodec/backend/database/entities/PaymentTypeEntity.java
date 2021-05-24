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
@Table(name="payment_type")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
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

    @OneToMany(mappedBy = "paymentType", fetch = FetchType.EAGER)
    private Set<TransactionEntity> transactions;
}
