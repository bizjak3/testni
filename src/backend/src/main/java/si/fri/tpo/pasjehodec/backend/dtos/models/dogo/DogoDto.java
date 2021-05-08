package si.fri.tpo.pasjehodec.backend.dtos.models.dogo;

import lombok.Data;

@Data
public class DogoDto {
    private Integer id;
    private String name;
    private String breed;
    private Integer breedId;
    private DogoUserDto owner;
}
