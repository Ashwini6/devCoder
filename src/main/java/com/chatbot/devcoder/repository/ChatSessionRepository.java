package com.chatbot.devcoder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chatbot.devcoder.model.ChatSession;

@Repository
public interface ChatSessionRepository extends JpaRepository<ChatSession, Long>{

	List<ChatSession> findAllByOrderByCreatedAtDesc();
}
