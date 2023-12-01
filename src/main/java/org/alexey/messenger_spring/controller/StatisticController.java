package org.alexey.messenger_spring.controller;

import lombok.RequiredArgsConstructor;
import org.alexey.messenger_spring.service.MessageService;
import org.alexey.messenger_spring.service.SessionService;
import org.alexey.messenger_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/statistic")
@RequiredArgsConstructor
public class StatisticController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public Map<String, Long> getStatistic(){
        Map<String, Long> statistic = new HashMap<>();
        statistic.put("total_registration_users", userService.getCountUsers());
        statistic.put("total_messages", messageService.getCountMessages());
        statistic.put("total_active_users", sessionService.getSessionCount());
        return statistic;
    }

}
