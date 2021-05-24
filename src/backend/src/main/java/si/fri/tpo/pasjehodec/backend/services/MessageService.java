package si.fri.tpo.pasjehodec.backend.services;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import si.fri.tpo.pasjehodec.backend.database.entities.MessageEntity;
import si.fri.tpo.pasjehodec.backend.database.entities.users.UserEntity;
import si.fri.tpo.pasjehodec.backend.database.repositories.MessageRepository;
import si.fri.tpo.pasjehodec.backend.database.repositories.UserRepository;
import si.fri.tpo.pasjehodec.backend.exceptions.DataNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public MessageEntity[] getAllMessages() {

        return messageRepository.findAll().toArray(new MessageEntity[0]);
    }

    public MessageEntity createNewMessage(MessageEntity entity, UserEntity sender, String recipient) throws DataNotFoundException {

        entity.setSender(sender);
        entity.setRecipient(userRepository.findByUsername(recipient)
            .orElseThrow(() -> new DataNotFoundException("Uporabnik ne obstaja"))
        );
        entity.setCreated(LocalDateTime.now());
        return messageRepository.save(entity);
    }

    public HashMap<String, List<MessageEntity>> getMessagesOfUser(UserEntity user) {
        var messages = messageRepository.findBySenderOrRecipient(user);

        var sendByUser = CollectionUtils.emptyIfNull(messages).stream()
                .filter(e -> e.getSender().getId().equals(user.getId()))
                .collect(Collectors.toList());

        var sendToUser = CollectionUtils.emptyIfNull(messages).stream()
                .filter(e -> e.getRecipient().getId().equals(user.getId()))
                .collect(Collectors.toList());

        var hash = new HashMap<String, List<MessageEntity>>();

        for(var m : sendByUser) {
            var list = hash.get(m.getRecipient().getUsername());
            if(list == null) {
                list = new ArrayList<>();
            }

            list.add(m);
            hash.put(m.getRecipient().getUsername(), list);
        }

        for(var m : sendToUser) {
            var list = hash.get(m.getSender().getUsername());
            if(list == null) {
                list = new ArrayList<>();
            }

            list.add(m);
            hash.put(m.getSender().getUsername(), list);
        }

        return hash;
    }
}
