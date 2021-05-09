package si.fri.tpo.pasjehodec.backend.dtos.models.dogo;

import lombok.Data;

@Data
public class DogoUserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String username;
}
