package com.chatbot.devcoder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatbot.devcoder.model.ChatSession;
import com.chatbot.devcoder.repository.ChatSessionRepository;

@Service
public class ChatService {
	
	private final ChatSessionRepository repository;
	
	public ChatService(ChatSessionRepository repository)
	{
		this.repository = repository;
	}

	public List<ChatSession> getAllSessions() 
	{
		return repository.findAllByOrderByCreatedAtDesc();
	}

	public ChatSession getSessions(Long id) {
		
	return	repository.findById(id).orElse(null);
		
	}

}
