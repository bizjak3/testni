package si.fri.tpo.pasjehodec.backend.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.MessageEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.MessageDto;
import si.fri.tpo.pasjehodec.backend.services.MessageService;

import java.util.Arrays;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageApi {

    private final MessageService messageService;
    // private final MessageEntityMapper messageEntityMapper;

    @GetMapping("get-all")
    public ResponseEntity<MessageEntity[]> getMessages() {
        return ResponseEntity.ok(
                Arrays.stream(messageService.getAllMessages())
                .toArray(MessageEntity[]::new)
        );
    }

    @PostMapping("post-message")
    public ResponseEntity<MessageEntity> postMessage(@RequestBody MessageEntity messageEntity) {
        MessageEntity entity = messageService.createNewMessage(messageEntity);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
