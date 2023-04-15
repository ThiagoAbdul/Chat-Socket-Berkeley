package chat.model;

import java.awt.Image;
import java.util.Collection;

public class Usuario {
	
	private long id;
	private String email;
	private String nome;
	private String senha;
	private Image foto;
	private Collection<Usuario> contatos;
	private Collection<GrupoDeUsuarios> grupos;
	
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
