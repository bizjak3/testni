package si.fri.tpo.pasjehodec.backend.database.entities.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import si.fri.tpo.pasjehodec.backend.database.entities.DogoEntity;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "owner")
    List<DogoEntity> dogos;


    //privzeto potrebno za implementirati zaradi security, se ne rabi
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
