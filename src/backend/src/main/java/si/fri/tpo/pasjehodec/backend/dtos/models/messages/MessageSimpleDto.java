package si.fri.tpo.pasjehodec.backend.dtos.models.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageSimpleDto {
    private String text;
    private LocalDateTime created;
    private Boolean sendByMe;
}
