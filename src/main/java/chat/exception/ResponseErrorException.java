package chat.exception;

import java.io.IOException;

public class ResponseErrorException extends IOException {

    public ResponseErrorException(Throwable cause) {
        this("Erro durante a operação do servidor", cause);

    }

    public ResponseErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
