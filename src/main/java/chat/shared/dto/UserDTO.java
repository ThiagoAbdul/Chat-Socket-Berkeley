package chat.shared.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private long id;
    private final String name;


    public UserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
