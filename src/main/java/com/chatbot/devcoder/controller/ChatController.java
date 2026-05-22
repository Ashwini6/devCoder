package com.chatbot.devcoder.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chatbot.devcoder.model.ChatSession;
import com.chatbot.devcoder.service.ChatService;

@Controller
public class ChatController {
	
	private final ChatService chatService;
	
	public ChatController(ChatService chatService)
	{
		this.chatService = chatService;
	}

	// home page - empty chat, sidebar shows all sessions
	@GetMapping("/")
	public String home(Model model) //model :-> it's inbuilt class which is used to transfer data to backend to fronted(thymelef)
	{
		List<ChatSession> sessions = chatService.getAllSessions();  //i called service layer & the service layer return the data in the form of list so that is why i stored inside the sessions(reference var) 
		
		model.addAttribute("sessions", sessions); //addAttribute -> it's a method, which is used to store a data inside a model so it cane be displayed in the ui(froentend) 
		model.addAttribute("current", null);
		
		return "chat";	 // chat is a chat.html, it is used to call the Html Page	
	}
	
	
	 // click sidebar item - open that session
	@GetMapping("/session/{id}")
	public String openSession(@PathVariable Long id, Model model)
	{
		
		List<ChatSession> sessions = chatService.getAllSessions(); 
		ChatSession current	= chatService.getSessions(id);
		
		
		model.addAttribute("sessions", sessions);
		model.addAttribute("current", current);
		
		return "chat";
	}
	
	
	
	 // send new message
	@PostMapping("/chat")
	public String chat(@RequestParam String message, Model model)
	{
		// ask AI and save to MySQL
		ChatSession current = chatService.askAI(message);
		
		// reload all sessions for sidebar
	
		List<ChatSession> sessions = chatService.getAllSessions();
		
		model.addAttribute("sessions", sessions);
		model.addAttribute("current", current);
		return "chat";
	}
	
	
	
	@PostMapping("/chat/delete/{id}")
	public String deleteChat(@PathVariable Long id) 
	{
		chatService.deleteConversation(id);
		return "redirect:/";
		
	}
}
