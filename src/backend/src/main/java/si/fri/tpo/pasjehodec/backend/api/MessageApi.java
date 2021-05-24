package si.fri.tpo.pasjehodec.backend.api;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.dtos.mappers.MessageEntityMapper;
import si.fri.tpo.pasjehodec.backend.dtos.models.MessageDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.messages.MessageRootDto;
import si.fri.tpo.pasjehodec.backend.dtos.models.messages.MessageSimpleDto;
import si.fri.tpo.pasjehodec.backend.exceptions.DataNotFoundException;
import si.fri.tpo.pasjehodec.backend.services.MessageService;

import java.util.*;

@RestController
@RequestMapping("/messages/")
@RequiredArgsConstructor
public class MessageApi {

    private final MessageService messageService;
    private final MessageEntityMapper messageEntityMapper;

    @GetMapping("get-all")
    public ResponseEntity<MessageEntity[]> getMessages() {
        return ResponseEntity.ok(
                Arrays.stream(messageService.getAllMessages())
                        .toArray(MessageEntity[]::new)
        );
    }

    @PostMapping("post-message")
    public ResponseEntity<MessageDto> postMessage(@RequestBody MessageDto messageDto,
                                                  @Parameter(hidden = true) @AuthenticationPrincipal UserEntity userEntity,
                                                  String receiver) throws DataNotFoundException {

        MessageEntity messageEntity = messageEntityMapper.castFromMessageDtoToMessageEntity(messageDto);

        MessageEntity entity = messageService.createNewMessage(messageEntity, userEntity, receiver);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(messageEntityMapper.castFromMessageEntityToMessageDto(entity));
    }

    @GetMapping
    public ResponseEntity<List<MessageRootDto>> getMessagesOfUser(@Parameter(hidden = true) @AuthenticationPrincipal UserEntity userEntity) {
        var data = messageService.getMessagesOfUser(userEntity);

        List<MessageRootDto> messages = new ArrayList<>();

        for(Map.Entry<String, List<MessageEntity>> entry : data.entrySet()) {
            String key = entry.getKey();
            var value = entry.getValue();

            messages.add(new MessageRootDto(
                    key,
                    CollectionUtils.emptyIfNull(value).stream()
                        .map(e -> new MessageSimpleDto(
                                e.getText(),
                                e.getCreated(),
                                userEntity.getId().equals(e.getSender().getId())
                        ))
                        .sorted(Comparator.comparing(MessageSimpleDto::getCreated))
                        .toArray(MessageSimpleDto[]::new)
            ));
        }

        return ResponseEntity.ok(messages);
    }
}
