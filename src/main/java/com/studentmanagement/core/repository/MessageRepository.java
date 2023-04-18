package com.studentmanagement.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanagement.core.model.MessageFeedback;

public interface MessageRepository extends JpaRepository<MessageFeedback, Integer> {

}
