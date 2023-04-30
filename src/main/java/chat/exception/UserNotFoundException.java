package chat.exception;

import chat.model.User;

public class UserNotFoundException extends RuntimeException{


    public UserNotFoundException() {
        super("Cliente não registrado");
    }

    public UserNotFoundException(User user){
        super(String.format("Usuario %d - %s Não registrado", user.getId(), user.getName()));
    }

}
