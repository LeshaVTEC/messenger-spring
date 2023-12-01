package org.alexey.messenger_spring.core.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "user_messages", name = "messages")
public class Message {
    @Id
    @Column(name = "id")
    private UUID uuid = UUID.randomUUID();
    @CreatedDate
    private LocalDateTime sentDate;
    @ManyToOne
    @JoinColumn(name = "user_id_from")
    private User userFrom;
    @ManyToOne
    @JoinColumn(name = "user_id_to")
    private User userTo;
    @Column(name = "message_text")
    private String text;


    public Message() {
    }

    public Message(LocalDateTime sentDate, User userFrom, User userTo, String text) {
        this.sentDate = sentDate;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getSentDate() {
        return sentDate;
    }

    public User getUserTo() {
        return userTo;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public Message setUserFrom(User userFrom) {
        this.userFrom = userFrom;
        return this;
    }

    public Message setUserTo(User userTo) {
        this.userTo = userTo;
        return this;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public Message setSentDate(LocalDateTime sentDate) {
        this.sentDate = sentDate;
        return this;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uuid=" + uuid +
                ", sentDate=" + sentDate +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", text='" + text + '\'' +
                '}';
    }
}
