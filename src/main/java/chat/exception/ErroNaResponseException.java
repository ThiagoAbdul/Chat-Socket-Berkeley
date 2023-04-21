package chat.exception;

import java.io.IOException;

public class ErroNaResponseException extends IOException {

    public ErroNaResponseException(Throwable cause) {
        this("Erro durante a operação do servidor", cause);

    }

    public ErroNaResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
