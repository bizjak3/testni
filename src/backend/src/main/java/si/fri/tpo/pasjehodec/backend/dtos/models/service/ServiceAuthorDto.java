package si.fri.tpo.pasjehodec.backend.dtos.models.service;

import lombok.Data;

@Data
public class ServiceAuthorDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String username;
}
