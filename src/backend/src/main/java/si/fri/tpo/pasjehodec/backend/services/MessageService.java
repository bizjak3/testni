package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageEntity[] getAllMessages() {

        return messageRepository.findAll().toArray(new MessageEntity[0]);
    }

    public MessageEntity createNewMessage(MessageEntity entity) {
        return messageRepository.save(entity);
    }
}
