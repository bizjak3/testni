package si.fri.tpo.pasjehodec.backend.dtos.models.login_register;

import lombok.Data;


@Data
public class RegisterDto {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
}
