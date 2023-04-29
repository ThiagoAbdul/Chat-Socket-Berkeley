package chat.shared;

import java.io.Serializable;

public class MyObjectTransferProtocol<T> implements Serializable {
    public final int CODE;

    private T object;

    private static final long serivalVersionUID = 1L;

    public MyObjectTransferProtocol(int CODE, T object) {
        this.CODE = CODE;
        this.object = object;
    }

    public T getObject() {
        return object;
    }
}
