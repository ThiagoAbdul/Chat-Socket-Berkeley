package chat.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem {
	

	private Long id;
	private String conteudo;
	private LocalTime horarioEnvio;
	private LocalDate dataEnvio;
	private LocalTime horarioEntrega;
	private LocalDate dataEntrega;
	private Usuario remente;
	private Usuario destinatario;
	
	public Long getId() {
		return id;
	}
	public String getConteudo() {
		return conteudo;
	}
	public LocalTime getHorarioEnvio() {
		return horarioEnvio;
	}
	public LocalDate getDataEnvio() {
		return dataEnvio;
	}
	public Usuario getRemente() {
		return remente;
	}
	public Usuario getDestinatario() {
		return destinatario;
	}
	
	public LocalTime getHorarioEntrega() {
		return horarioEntrega;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	

}
