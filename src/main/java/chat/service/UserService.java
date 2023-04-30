package chat.service;

import chat.model.User;
import chat.shared.dto.UserDTO;

public class UserService {

    private static Long userId = 0L;

    public UserDTO userToDTO(User user){
        return new UserDTO(user.getName());
    }

    public long getUniqueId(){
        synchronized (userId){
            return ++userId;
        }
    }

}
