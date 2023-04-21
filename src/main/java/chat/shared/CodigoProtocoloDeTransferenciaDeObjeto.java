package chat.shared;

import java.io.Serializable;

public enum CodigoProtocoloDeTransferenciaDeObjeto implements Serializable {
    ERRO(0),
    OK(1),
    REGISTRO(2),
    ENVIO_DE_MENSAGEM(3),
    VERIFICAR_CAIXA_DE_ENTRADA(4),
    ENVIO_DE_OUTROS_USUARIOS(5);

    private final int codigo;
    CodigoProtocoloDeTransferenciaDeObjeto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
