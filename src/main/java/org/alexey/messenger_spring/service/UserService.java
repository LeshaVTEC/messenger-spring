package org.alexey.messenger_spring.service;

import org.alexey.messenger_spring.core.dto.UserLoginDto;
import org.alexey.messenger_spring.core.dto.UserRegistrationDto;
import org.alexey.messenger_spring.core.entity.User;
import org.alexey.messenger_spring.repository.UserRepository;
import org.alexey.messenger_spring.transformer.UserTransformer;
import org.alexey.messenger_spring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTransformer userTransformer;

    @Autowired
    private UserValidator userValidator;
    public UserRegistrationDto registrationUser(UserRegistrationDto userRegDto) {
        User userEntityForSave = userTransformer.transformEntityFromDto(userRegDto);
        userValidator.validateUsernameForSave(userRegDto);
        User userSaved = userRepository.save(userEntityForSave);
        return userTransformer.transformDtoFromEntity(userSaved);
    }

    public UUID authenticateUser(UserLoginDto userLoginDto) {

        if (userLoginDto.getUsername().isBlank() && userLoginDto.getPassword().isBlank()) {
            throw new RuntimeException("enter your username and password");
        }
        UUID authenticatedUserId = userRepository.findUuidByUsernameIgnoreCaseAndPassword(
                userLoginDto.getUsername(),
                userLoginDto.getPassword()
        );
        if (authenticatedUserId == null) {
            throw new RuntimeException(" incorrect login or password entered. try again");
        }
        return authenticatedUserId;
    }

    public Long getCountUsers(){
        return userRepository.count();
    }
}
