package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.MessageRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageEntity[] getAllMessages() {

        return messageRepository.findAll().toArray(new MessageEntity[0]);
    }

    public MessageEntity createNewMessage(MessageEntity entity, UserEntity sender, Integer recipientId) {

        entity.setSender(sender);
        entity.setRecipient(userRepository.getOne(recipientId));
        entity.setCreated(LocalDateTime.now());
        return messageRepository.save(entity);
    }
}
