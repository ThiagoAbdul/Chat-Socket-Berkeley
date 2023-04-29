package chat.exception;

import java.io.IOException;

public class UnknowCodeException extends IOException {

    public UnknowCodeException(int code) {
        super("Código desconhecido: " + code);
    }
}
