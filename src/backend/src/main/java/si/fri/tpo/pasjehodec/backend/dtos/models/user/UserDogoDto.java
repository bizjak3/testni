package si.fri.tpo.pasjehodec.backend.dtos.models.user;

import lombok.Data;

@Data
public class UserDogoDto {
    private Integer id;
    private String name;
    private String breed;
    private Integer breedId;
}
