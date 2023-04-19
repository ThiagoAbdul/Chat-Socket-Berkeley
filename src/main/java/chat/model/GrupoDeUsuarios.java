package chat.model;

import java.awt.Image;
import java.io.Serializable;
import java.util.Collection;

public class GrupoDeUsuarios implements Serializable {
	private long id;
	private String nome;
	private Collection<Usuario> participantes;
	private Image foto;

	private static final long serivalVersionUID = 1L;

}
