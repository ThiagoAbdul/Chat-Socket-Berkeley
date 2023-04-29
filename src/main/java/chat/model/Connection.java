package chat.model;

import chat.shared.dto.UserDTO;

import java.nio.channels.SocketChannel;

public class Connection {
    private final SocketChannel channel;
    private final UserDTO userDTO;

    public Connection(SocketChannel channel, UserDTO userDTO) {
        this.channel = channel;
        this.userDTO = userDTO;
    }

    public SocketChannel getChannel() {
        return channel;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }


}
