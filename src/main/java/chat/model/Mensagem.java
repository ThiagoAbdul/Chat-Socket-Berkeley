package chat.model;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem {
=======
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem implements Serializable {
>>>>>>> abdul
	

	private Long id;
	private String conteudo;
	private LocalTime horarioEnvio;
	private LocalDate dataEnvio;
<<<<<<< HEAD
	private LocalTime horarioEntrega;
	private LocalDate dataEntrega;
	private Usuario remente;
	private Usuario destinatario;
=======
	private Usuario remente;
	private Usuario destinatario;

	private static final long serivalVersionUID = 1L;
>>>>>>> abdul
	
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
	
<<<<<<< HEAD
	public LocalTime getHorarioEntrega() {
		return horarioEntrega;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	
=======

>>>>>>> abdul

}
