package chat.model;
import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Usuario usuario)) return false;
		return getId() == usuario.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
}