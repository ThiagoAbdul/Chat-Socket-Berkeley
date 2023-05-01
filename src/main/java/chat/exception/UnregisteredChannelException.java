package chat.exception;

import java.io.IOException;

public class UnregisteredChannelException extends IOException {

    public UnregisteredChannelException() {
        super("Canal não registrado");
    }
}
