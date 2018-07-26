package com.demo.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ChatController {
	
	@MessageMapping("/Hello")
	@SendTo("/topic/greetings")
	public Greeting Hello(HelloMessage message) throws Exception {
		Thread.sleep(100);
		System.out.println("message2:"+ message);
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}

}
