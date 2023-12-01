package org.alexey.messenger_spring.repository;

import org.alexey.messenger_spring.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("select uuid from User u where lower(u.username) = lower(:username) and u.password = :password")
    UUID findUuidByUsernameIgnoreCaseAndPassword(String username, String password);

    boolean existsByUsernameIgnoreCase(String username);


}
