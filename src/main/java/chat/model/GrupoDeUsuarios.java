package chat.model;

import java.awt.Image;
import java.util.Collection;

public class GrupoDeUsuarios {
	private long id;
	private String nome;
	private Collection<Usuario> participantes;
	private Image foto;

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Collection<Usuario> getParticipantes() {
		return participantes;
	}

	public Image getFoto() {
		return foto;
	}
}
