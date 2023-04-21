package chat.exception;

import chat.model.Usuario;

public class UsuarioNaoRegistradoException extends RuntimeException{


    public UsuarioNaoRegistradoException() {
        super("Cliente não registrado");
    }

    public UsuarioNaoRegistradoException(Usuario usuario){
        super(String.format("Usuario %d - %s Não registrado", usuario.getId(), usuario.getNome()));
    }

}
