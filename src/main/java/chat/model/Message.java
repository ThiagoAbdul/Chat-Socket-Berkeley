package chat.model;


import chat.shared.dto.UserDTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class Message {

	private Long id;
	private final String content;
	private LocalTime horarioEnvio;
	private LocalDate dataEnvio;
	private final User sender;
	private final UserDTO receiver;


	public Message(User sender, String content, UserDTO receiver){
		this.sender = sender;
		this.content = content;
		this.receiver = receiver;
	}

	
	public Long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public LocalTime getHorarioEnvio() {
		return horarioEnvio;
	}
	public LocalDate getDataEnvio() {
		return dataEnvio;
	}
	public User getSender() {
		return sender;
	}
	public UserDTO getReceiver() {
		return receiver;
	}

}
