package chat.shared;

import java.io.Serializable;

public class ProtocoloDeTransferenciaDeObjeto<T> implements Serializable {
    public final int CODIGO;
    /*  1 - Registro
        2 - Envio de mensagem
        3 - Verificar caixa de mensagens
    */
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
