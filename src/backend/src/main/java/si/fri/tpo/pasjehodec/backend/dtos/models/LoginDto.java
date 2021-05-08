package si.fri.tpo.pasjehodec.backend.dtos.models;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
