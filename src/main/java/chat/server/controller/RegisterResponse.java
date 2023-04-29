package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashSet;

public class RegisterResponse implements Response{

    private final ChatServer server;
    private final SocketChannel clientChannel;
    private final UserDTO userDTO;

    public RegisterResponse(ChatServer server, SocketChannel clientChannel, UserDTO userDTO) {
        this.server = server;
        this.clientChannel = clientChannel;
        this.userDTO = userDTO;
    }

    @Override
    public void doResponse() {
        Connection newConnection = new Connection(clientChannel, userDTO);
        Collection<Connection> otherConnections = new HashSet<>(this.server.getConnections());
        if(this.server.getConnections().add(newConnection)){
            sendNewContactToAll(otherConnections);
        }

        // TODO
    }

    private void sendNewContactToAll(Collection<Connection> otherConnections){
        otherConnections.stream()
                .map(connection -> new ChannelWriter(connection.getChannel()))
                .forEach(writer -> {
                    try {
                        writer.write(MyObjectTransferProtocolFactory.RECEIVE_NEW_CONTACT(this.userDTO));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
