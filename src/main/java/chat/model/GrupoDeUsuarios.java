package chat.model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Collection;

public class GrupoDeUsuarios implements Serializable {
	private long id;
	private String nome;
	private Collection<User> participantes;
	private Image foto;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Collection<User> getParticipantes() {
		return participantes;
	}

	public Image getFoto() {
		return foto;
	}

	private static final long serivalVersionUID = 1L;


}
