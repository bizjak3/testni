package si.fri.tpo.pasjehodec.backend.dtos.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {

    private Integer id;

    private String text;

    private LocalDateTime created;

//    private Integer userSender;
//    private Integer userReceiver;
}
