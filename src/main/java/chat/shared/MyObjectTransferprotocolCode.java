package chat.shared;

import java.io.Serializable;

public enum MyObjectTransferprotocolCode implements Serializable {
    ERROR(0),
    OK(1),
    REGISTER(2),
    SEND_PRIVATE_MESSAGE(3),
    SEND_BROADCAST_MESSAGE(4),
    RECEIVE_NEW_CONTACT(5);

    private final int code;
    MyObjectTransferprotocolCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
