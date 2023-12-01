package org.alexey.messenger_spring.transformer;

import org.alexey.messenger_spring.core.dto.UserRegistrationDto;
import org.alexey.messenger_spring.core.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    public User transformEntityFromDto(UserRegistrationDto userRegDto){
       return new User()
               .setUsername(userRegDto.getUsername())
               .setPassword(userRegDto.getPassword())
               .setFullName(userRegDto.getFullName())
               .setBirthday(userRegDto.getBirthday());
    }

    public UserRegistrationDto transformDtoFromEntity(User entity){
        return new UserRegistrationDto(
                entity.getUsername(),
                entity.getPassword(),
                entity.getFullName(),
                entity.getBirthday()
        );
    }
}
