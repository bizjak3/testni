package si.fri.tpo.pasjehodec.backend.dtos.models.login_register;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class RegisterDto {
    @NotNull(message = "Ime mora biti izpolnjeno")
    private String name;
    @NotNull(message = "Priimek mora biti izpolnjen")
    private String surname;
    @NotNull(message = "Email mora biti izpolnjen")
    private String email;
    @NotNull(message = "Uporabniško ime mora biti izpolnjeno")
    private String username;
    @NotNull(message = "Geslo mora biti izpolnjeno")
    private String password;
}
