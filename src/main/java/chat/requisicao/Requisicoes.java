package chat.requisicao;

import chat.model.Usuario;
import chat.shared.CodigoProtocoloDeTransferenciaDeObjeto;

import java.util.Collection;

public abstract class Requisicoes {

    public static final Requisicao<Usuario, Long> REGISTRO = new Requisicao<>(
            CodigoProtocoloDeTransferenciaDeObjeto.REGISTRO.getCodigo());
    public static final Requisicao<Long, Collection<Usuario>> DESCOBRIR_OUTROS_USUARIOS = new Requisicao<>(
            CodigoProtocoloDeTransferenciaDeObjeto.DESCOBRIR_OUTROS_USUARIOS.getCodigo());
}
