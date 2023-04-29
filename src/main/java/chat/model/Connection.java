package chat.model;

import java.nio.channels.SocketChannel;

public class Connection {
    private final SocketChannel channel;
    private Usuario usuario;

    public Connection(SocketChannel channel) {
        this.channel = channel;
    }

    public SocketChannel getChannel() {
        return channel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
