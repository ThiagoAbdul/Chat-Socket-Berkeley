package chat.exception;

import chat.model.User;

public class UsuarioNaoRegistradoException extends RuntimeException{


    public UsuarioNaoRegistradoException() {
        super("Cliente não registrado");
    }

    public UsuarioNaoRegistradoException(User user){
        super(String.format("Usuario %d - %s Não registrado", user.getId(), user.getName()));
    }

}
