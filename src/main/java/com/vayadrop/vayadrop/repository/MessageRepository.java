package com.vayadrop.vayadrop.repository;

import com.vayadrop.vayadrop.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
