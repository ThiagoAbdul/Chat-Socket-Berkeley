package chat.model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Message implements Serializable {

	private Long id;
	private String content;
	private LocalTime horarioEnvio;
	private LocalDate dataEnvio;
	private User sender;
	private User destinatario;

	private static final long serivalVersionUID = 1L;

	public Message(User sender, String content){
		this.sender = sender;
		this.content = content;
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
	public User getDestinatario() {
		return destinatario;
	}

	@Override
	public String toString() {
		return String.format("%s: %s%n", sender.getName(), content);
	}
}
