package chat.shared.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private String name;

    public UserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
