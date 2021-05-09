package si.fri.tpo.pasjehodec.backend.dtos.models.login_register;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotNull(message = "Uporabniško ime mora biti izpolnjeno")
    private String username;
    @NotNull(message = "Geslo mora biti izpolnjeno")
    private String password;
}
