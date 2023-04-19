package chat.model;

import java.awt.Image;
<<<<<<< HEAD
import java.util.Collection;

public class Usuario {
=======
import java.io.Serializable;
import java.util.Collection;

public class Usuario implements Serializable {
>>>>>>> abdul
	
	private long id;
	private String email;
	private String nome;
	private String senha;
	private Image foto;
	private Collection<Usuario> contatos;
	private Collection<GrupoDeUsuarios> grupos;
<<<<<<< HEAD
=======

	private static final long serivalVersionUID = 1L;
>>>>>>> abdul
	
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	public String getSenha() {
		return senha;
	}
	public Image getFoto() {
		return foto;
	}
	public Collection<Usuario> getContatos() {
		return contatos;
	}
	public Collection<GrupoDeUsuarios> getGrupos() {
		return grupos;
	}
	
	

}
