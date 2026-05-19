package com.chatbot.devcoder.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chatbot.devcoder.model.ChatSession;
import com.chatbot.devcoder.service.ChatService;

@Controller
public class ChatController {
	
	private final ChatService chatService;
	
	public ChatController(ChatService chatService)
	{
		this.chatService = chatService;
	}

	@GetMapping("/")
	public String home(Model model) //model :-> it's inbuilt class which is used to transfer data to backend to fronted(thymelef)
	{
		List<ChatSession> sessions = chatService.getAllSessions();  //i called service layer & the service layer return the data in the form of list so that is why i stored inside the sessions(reference var) 
		
		model.addAttribute("sessions", sessions); //addAttribute -> it's a method, which is used to store a data inside a model so it cane be displayed in the ui(froentend) 
		model.addAttribute("current", null);
		
		return "chat";	 // chat is a chat.html, it is used to call the Html Page	
	}
	
	
	
	@GetMapping("/session/{id}")
	public String openSession(@PathVariable Long id, Model model)
	{
		
		List<ChatSession> sessions = chatService.getAllSessions(); 
		ChatSession current	= chatService.getSessions(id);
		
		
		model.addAttribute("sessions", sessions);
		model.addAttribute("current", current);
		
		
		return "chat";
		
	}
	
	
}
