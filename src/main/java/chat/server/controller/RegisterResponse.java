package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.model.User;
import chat.shared.MyObjectTransferProtocolFactory;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashSet;

public class RegisterResponse implements Response{

    private final ChatServer server;
    private final SocketChannel clientChannel;
    private final User user;

    public RegisterResponse(ChatServer server, SocketChannel clientChannel, User user) {
        this.server = server;
        this.clientChannel = clientChannel;
        this.user = user;
    }

    @Override
    public void doResponse() {
        Connection newConnection = new Connection(clientChannel, user);
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
                        writer.write(MyObjectTransferProtocolFactory.RECEIVE_NEW_CONTACT(this.user));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

    }
}
