package chat.shared;

import java.io.Serializable;
import java.util.HashSet;

public class ProtocoloDeTransferenciaDeObjeto<T> implements Serializable {
    public final int CODIGO;

    private T objeto;

    private static final long serivalVersionUID = 1L;

    public ProtocoloDeTransferenciaDeObjeto(int CODIGO, T objeto) {
        this.CODIGO = CODIGO;
        this.objeto = objeto;
    }

    public T getObjeto() {
        return objeto;
    }
}
