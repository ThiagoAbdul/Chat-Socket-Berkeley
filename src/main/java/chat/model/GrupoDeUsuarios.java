package chat.model;

import java.awt.Image;
<<<<<<< HEAD
import java.util.Collection;

public class GrupoDeUsuarios {
=======
import java.io.Serializable;
import java.util.Collection;

public class GrupoDeUsuarios implements Serializable {
>>>>>>> abdul
	private long id;
	private String nome;
	private Collection<Usuario> participantes;
	private Image foto;

<<<<<<< HEAD
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
=======
	private static final long serivalVersionUID = 1L;

>>>>>>> abdul
}
