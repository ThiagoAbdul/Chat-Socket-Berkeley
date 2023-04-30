package chat.shared.protocol;

import java.io.Serializable;

public enum MyObjectTransferprotocolCode implements Serializable {
    ERROR(0),
    REGISTER(1),
    RECEIVE_ID(2),
    SEND_PRIVATE_MESSAGE(3),
    SEND_GLOBAL_MESSAGE(4),
    RECEIVE_NEW_CONTACT(5),
    RECEIVE_ALL_CONTACTS(6),
    RECEIVE_PRIVATE_MESSAGE(7),
    RECEIVE_GLOBAL_MESSAGE(8);

    private final int code;
    MyObjectTransferprotocolCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
