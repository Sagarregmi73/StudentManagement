package com.studentmanagement.core.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.core.model.MessageFeedback;
import com.studentmanagement.core.repository.MessageRepository;
import com.studentmanagement.core.repository.service.MessageFeedbackService;
@Service
public class MessageFeedbackServiceImpl implements MessageFeedbackService {
	@Autowired
private MessageRepository messageRepo;
	@Override
	public void addMessageFeedback(MessageFeedback messageFeedback) {
		// TODO Auto-generated method stub
		messageRepo.save(messageFeedback);
	}
	@Override
	public void deleteMessageFeedback(int id) {
		// TODO Auto-generated method stub
		messageRepo.deleteById(id);
	}
	@Override
	public void updateMessageFeedback(MessageFeedback messageFeedback) {
		// TODO Auto-generated method stub
		messageRepo.save(messageFeedback);
	}
	@Override
	public List<MessageFeedback> getMessageFeedback() {
		// TODO Auto-generated method stub
		return messageRepo.findAll();
	}
	@Override
	public MessageFeedback getMessageFeedbackById(int id) {
		// TODO Auto-generated method stub
		return messageRepo.getById(id);
	}

}
