package org.alexey.messenger_spring.validator;

import org.alexey.messenger_spring.core.dto.UserRegistrationDto;
import org.alexey.messenger_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;

    public void validateUsernameForSave(UserRegistrationDto userRegDto) {
        if (userRepository.existsByUsernameIgnoreCase(userRegDto.getUsername())) {
          throw new RuntimeException("User already exist by username = " + userRegDto.getUsername());
        }
    }
}
