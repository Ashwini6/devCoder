package com.chatbot.devcoder.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class OllamaService {
	
	 private final WebClient webClient;
	    private final ObjectMapper objectMapper = new ObjectMapper();
	    
	    
	    public OllamaService() {
	        this.webClient = WebClient.create("http://localhost:11434");
	    }
	    
	    
	    public String generateResponse(String prompt)
	    {
	    	try {
	    		Map<String, Object> requestMap = new HashMap<>();
	            requestMap.put("model", "llama3.2");
	            requestMap.put("prompt", prompt);
	            requestMap.put("stream", false);
	            
	            String request = objectMapper.writeValueAsString(requestMap);
	            
	            String rawResponse = webClient.post()
	                    .uri("/api/generate")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .bodyValue(request)
	                    .retrieve()
	                    .bodyToMono(String.class)
	                    .block();
	            
	            JsonNode jsonNode = objectMapper.readTree(rawResponse);
	            return jsonNode.get("response").asText();
	            
	            
	    	 } catch (Exception e) {
	             return "Error: " + e.getMessage();
	         }
	     }
	 }
