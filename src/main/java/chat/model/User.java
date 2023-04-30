package chat.model;

import chat.shared.dto.UserDTO;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class User {

	private long id;
	private String name;

	private final Collection<UserDTO> contacts = new HashSet<>();


	public User(long id){
		this.id = id;
	}

	public User(String name) {
		this.name = name;
	}

	public User(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User user)) return false;
		return getId() == user.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "[" + id + " - " + name + "]";
	}
}