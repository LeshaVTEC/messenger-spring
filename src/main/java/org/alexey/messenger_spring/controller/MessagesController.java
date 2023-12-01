package org.alexey.messenger_spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.alexey.messenger_spring.core.dto.MessageDtoRequest;
import org.alexey.messenger_spring.core.dto.MessageDtoResponse;
import org.alexey.messenger_spring.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/messages")
@RequiredArgsConstructor
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<MessageDtoResponse> getAllUserMessages(HttpServletRequest request){
        Object id = request.getSession().getAttribute("UUID");
        return id != null ? messageService.getAllUserMessages(id.toString()) : Collections.emptyList();
    }

    @PostMapping
    public MessageDtoResponse sendMessage(@RequestBody MessageDtoRequest messageDtoRequest, HttpServletRequest request){
        String idFrom = request.getSession().getAttribute("UUID").toString();
       return messageService.saveMessage(messageDtoRequest, idFrom);
    }
}
