package org.alexey.messenger_spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.alexey.messenger_spring.core.dto.UserLoginDto;
import org.alexey.messenger_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/login")
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String login(@RequestBody UserLoginDto dto, HttpServletRequest request) {
        UUID uuid = userService.authenticateUser(dto);
        request.getSession().setAttribute("UUID", uuid);
        return "Authenticated with uuid " + uuid;
    }
}
