package org.alexey.messenger_spring.core.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "user_messages", name = "users")
public class User {
    @Id
    @Column(name = "id")
    private UUID uuid = UUID.randomUUID();

    private String username;

    private String password;

    @Column(name = "full_name")
    private String fullName;

    private LocalDate birthday;

    @CreatedDate
    @Column(name = "registration_date")
    private LocalDateTime registeredDate;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

    public User() {
    }

    public User(String username, String password, String fullName, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public User setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public User setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public User setRole(UserRole role) {
        this.role = role;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", registeredDate=" + registeredDate +
                ", role=" + role +
                '}';
    }
}
