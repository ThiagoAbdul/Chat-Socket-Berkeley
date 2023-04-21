package chat.model;
import java.io.Serializable;

public class Usuario implements Serializable {

	private long id;
	private String nome;


	private static final long serivalVersionUID = 1L;

	public Usuario(){ }

	public Usuario(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


}