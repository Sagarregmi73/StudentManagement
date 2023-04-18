package com.studentmanagement.core.repository.service;

import java.util.List;

import com.studentmanagement.core.model.MessageFeedback;


public interface MessageFeedbackService {
	void addMessageFeedback(MessageFeedback messageFeedback);
	void deleteMessageFeedback(int id);
	void updateMessageFeedback(MessageFeedback messageFeedback);
	List <MessageFeedback > getMessageFeedback();

	MessageFeedback getMessageFeedbackById(int id);
}
