package org.alexey.messenger_spring.transformer;

import org.alexey.messenger_spring.core.dto.MessageDtoRequest;
import org.alexey.messenger_spring.core.dto.MessageDtoResponse;
import org.alexey.messenger_spring.core.entity.Message;
import org.alexey.messenger_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageTransformer {

    @Autowired
    private UserRepository userRepository;

    public Message transformEntityFromDto(MessageDtoRequest messageDtoRequest){
        return new Message()
                .setUserTo(userRepository.getReferenceById(UUID.fromString(messageDtoRequest.getUserIdTo())))
                .setText(messageDtoRequest.getText());
    }

    public MessageDtoRequest transformDtoReqFromEntity(Message message){
        return new MessageDtoRequest()
                .setUserIdTo(message.getUserTo().getUuid().toString())
                .setText(message.getText());
    }

    public MessageDtoResponse transformDtoRespFromEntity(Message message){
        return new MessageDtoResponse()
                .setSentDate(message.getSentDate())
                .setUserIdFrom(message.getUserFrom().getUuid().toString())
                .setUserIdTo(message.getUserTo().getUuid().toString())
                .setText(message.getText());
    }
}
