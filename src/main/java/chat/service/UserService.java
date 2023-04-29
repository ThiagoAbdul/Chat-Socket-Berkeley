package chat.service;

import chat.model.User;
import chat.shared.dto.UserDTO;

public class UserService {

    public UserDTO userToDTO(User user){
        return new UserDTO(user.getName());
    }

}
