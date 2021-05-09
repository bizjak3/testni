package si.fri.tpo.pasjehodec.backend.dtos.models.user;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String username;
    private Boolean isDogOwner;
    private Boolean isServiceWorker;
    private Boolean isAdmin;

    List<UserDogoDto> dogos;
}
