package org.alexey.messenger_spring.controller;

import lombok.RequiredArgsConstructor;
import org.alexey.messenger_spring.core.dto.UserRegistrationDto;
import org.alexey.messenger_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserRegistrationDto registration(@RequestBody UserRegistrationDto userRegDto){
        return userService.registrationUser(userRegDto);

    }
}
