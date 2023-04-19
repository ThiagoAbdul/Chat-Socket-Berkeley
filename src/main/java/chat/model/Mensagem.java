package chat.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem implements Serializable {
	

	private Long id;
	private String conteudo;
	private LocalTime horarioEnvio;
	private LocalDate dataEnvio;
	private Usuario remente;
	private Usuario destinatario;

	private static final long serivalVersionUID = 1L;
	
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
	


}
