package chat.model;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	private long id;
	private String name;

	private static final long serivalVersionUID = 1L;

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