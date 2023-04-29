package chat.model;

import java.nio.channels.SocketChannel;

public class Connection {
    private final SocketChannel channel;
    private User user;

    public Connection(SocketChannel channel, User user) {
        this.channel = channel;
        this.user = user;
    }

    public SocketChannel getChannel() {
        return channel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
