package chat.shared;

import java.io.Serializable;

public enum CodigoProtocoloDeTransferenciaDeObjeto implements Serializable {
    REGISTRO(1),
    ENVIO_DE_MENSAGEM(2),
    VERIFICAR_CAIXA_DE_ENTRADA(3);

    private int codigo;
    CodigoProtocoloDeTransferenciaDeObjeto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
