package si.fri.tpo.pasjehodec.backend.database.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
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
    private List<DogoEntity> dogos;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<ServiceEntity> services;

    @OneToMany(mappedBy = "sender")
    private List<MessageEntity> messages;

    @OneToMany(mappedBy = "cardOwner", fetch = FetchType.EAGER)
    private List<PaymentTypeEntity> paymentTypes;


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
