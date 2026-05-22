package com.chatbot.devcoder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chatbot.devcoder.model.ChatSession;
import com.chatbot.devcoder.repository.ChatSessionRepository;

@Service
public class ChatService {
	
	 private final OllamaService ollamaService;
	 private final ChatSessionRepository repository;

	    
	    public ChatService(OllamaService ollamaService,
	                       ChatSessionRepository repository) {
	    	
	        this.ollamaService = ollamaService;
	        this.repository = repository;
	    }
	
	    
	    
	  public List<ChatSession> getAllSessions() {
	        return repository.findAllByOrderByCreatedAtDesc();
	    }		
	  
	  
	  

	public ChatSession getSessions(Long id) {
		
	return	repository.findById(id).orElse(null);
		
	}

	
	public ChatSession askAI(String question) {
		
		ChatSession session = new ChatSession(question);
		
		session = repository.save(session);
		
		StringBuilder prompt = new StringBuilder();
		prompt.append("You are a code-only assistant. \n");
		prompt.append("RULES:\n");
		prompt.append("1. output only raw code \n");
		prompt.append("2. No comments \n");
		prompt.append("3. No explanation \n");
		prompt.append("4. No extra text \n");
		prompt.append("5. Only the code block \n\n");
		prompt.append(" write code for:").append(question);
		
		
		
		String answer = ollamaService.generateResponse(prompt.toString());
        String cleanAnswer = removeComments(answer);

		
		session.setAnswer(cleanAnswer);
		repository.save(session);
		
		return session;
	}
	
	
	
	  
	  public void deleteConversation(Long id) {
			repository.deleteById(id);
	  }
	  
	 

	   private String removeComments(String code) {
	        code = code.replaceAll("//[^\n]*", "");
	        code = code.replaceAll(
	            "/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", "");
	        code = code.replaceAll(
	            "(?m)^\\s*$[\n\r]{1,}", "\n");
	        return code.trim();
	   }

	}


