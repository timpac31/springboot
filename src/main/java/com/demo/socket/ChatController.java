package com.demo.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@MessageMapping("/Hello")
	@SendTo("/topic/greetings")
	public HelloMessage Hello(HelloMessage message) throws Exception {
		Thread.sleep(100);
		return message;
	}

}
