package si.fri.tpo.pasjehodec.backend.database.entities.users;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.PaymentTypeEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.ServiceEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String password;

    private Boolean isDogOwner = false;
    private Boolean isServiceWorker = false;
    private Boolean isAdmin = false;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<DogoEntity> dogos;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<ServiceEntity> services;

    @OneToMany(mappedBy = "sender")
    private Set<MessageEntity> messages;

    @OneToMany(mappedBy = "recipient")
    private Set<MessageEntity> messagesReceived;

    @OneToMany(mappedBy = "cardOwner")
    private Set<PaymentTypeEntity> paymentTypes;

    public UserEntity(String name, String surname, String email, String username) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.username = username;
    }

    //privzeto potrebno za implementirati zaradi security, se ne rabi
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var list = new ArrayList<SimpleGrantedAuthority>();
        if(isDogOwner)
            list.add(new SimpleGrantedAuthority(UserType.DOG_OWNER));
        if(isServiceWorker)
            list.add(new SimpleGrantedAuthority(UserType.SERVICE_WORKER));
        if(isAdmin)
            list.add(new SimpleGrantedAuthority(UserType.ADMIN));

        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
