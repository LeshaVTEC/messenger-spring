package org.alexey.messenger_spring.service;

import jakarta.annotation.PostConstruct;
import org.alexey.messenger_spring.core.dto.MessageDtoRequest;
import org.alexey.messenger_spring.core.dto.MessageDtoResponse;
import org.alexey.messenger_spring.core.entity.Message;
import org.alexey.messenger_spring.core.entity.User;
import org.alexey.messenger_spring.repository.MessageRepository;
import org.alexey.messenger_spring.repository.UserRepository;
import org.alexey.messenger_spring.transformer.MessageTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageTransformer messageTransformer;

    public List<MessageDtoResponse> getAllUserMessages(String userId){
//        return messageRepository.findAllByUserFromOrUserTo(
//                        userRepository.getReferenceById(UUID.fromString(userId)),
//                        userRepository.getReferenceById(UUID.fromString(userId))
//                )
        return messageRepository.findAllByUserIdFromOrUserIdTo(
                        UUID.fromString(userId),
                        UUID.fromString(userId)
                )
                .stream()
                .map(it -> messageTransformer.transformDtoRespFromEntity(it))
                .collect(Collectors.toList());
    }

    public MessageDtoResponse saveMessage(MessageDtoRequest messageDtoRequest, String idFrom){
        Message messageForSave = messageTransformer.transformEntityFromDto(messageDtoRequest);
        messageForSave.setUserFrom(userRepository.getReferenceById(UUID.fromString(idFrom))).setSentDate(LocalDateTime.now());
        Message savedMessage = messageRepository.save(messageForSave);
        return messageTransformer.transformDtoRespFromEntity(savedMessage);
    }

    public Long getCountMessages(){
        return messageRepository.count();
    }
}
