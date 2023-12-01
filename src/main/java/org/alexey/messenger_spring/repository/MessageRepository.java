package org.alexey.messenger_spring.repository;

import org.alexey.messenger_spring.core.entity.Message;
import org.alexey.messenger_spring.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> findAllByUserFromOrUserTo(User userFrom, User userTo);

    @Query("SELECT m FROM Message m WHERE m.userFrom.uuid = :userIdFrom OR m.userTo.uuid = :userIdTo")
    List<Message> findAllByUserIdFromOrUserIdTo(UUID userIdFrom, UUID userIdTo);

}
