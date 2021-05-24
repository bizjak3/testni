package si.fri.tpo.pasjehodec.backend.dtos.models.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRootDto {
    private String username;
    private MessageSimpleDto[] messages;
}
