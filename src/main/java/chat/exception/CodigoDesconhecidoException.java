package chat.exception;

import java.io.IOException;

public class CodigoDesconhecidoException extends IOException {

    public CodigoDesconhecidoException(int codigo) {
        super("Código desconhecido: " + codigo);
    }
}
