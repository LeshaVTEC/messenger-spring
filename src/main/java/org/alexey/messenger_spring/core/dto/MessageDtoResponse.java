package org.alexey.messenger_spring.core.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class MessageDtoResponse {

        private LocalDateTime sentDate;
        private String userIdTo;
        private String userIdFrom;
        private String text;

}
