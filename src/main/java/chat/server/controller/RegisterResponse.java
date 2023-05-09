package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.service.UserService;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.stream.Collectors;

@Log4j2
public class RegisterResponse implements ServerResponse {

    private final ChatServer server;
    private final SocketChannel clientChannel;
    private final UserDTO userDTO;
    private final UserService userService;
    private final ChannelWriter writer;

    public RegisterResponse(ChatServer server, SocketChannel clientChannel, UserDTO userDTO) {
        this.server = server;
        this.clientChannel = clientChannel;
        this.userDTO = userDTO;
        this.userService = new UserService();
        writer = new ChannelWriter(this.clientChannel);
    }

    @Override
    public void doResponse() throws IOException{
        Connection newConnection = new Connection(clientChannel, userDTO);
        long uniqueId = userService.getUniqueId();
        userDTO.setId(uniqueId);
        try {
            sendNewContactToAll();
            sendAllContactsToNew();
            this.server.getConnections().put(uniqueId, newConnection);
            Thread.sleep(5); // Necessário!!!
            sendIdToUser(uniqueId);
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            sendIdToUser(uniqueId);
        }

    }

    private void sendNewContactToAll() throws IOException{
        var motp = MyObjectTransferProtocolFactory.RECEIVE_NEW_CONTACT(this.userDTO);
        for(Connection connection: server.getConnections().values()){
            new ChannelWriter(connection.getChannel()).write(motp);
        }

    }

    private void sendAllContactsToNew() throws IOException {
        var otherUsers = server.getConnections().values()
                .stream()
                .unordered()
                .map(Connection::getUserDTO)
                .collect(Collectors.toSet());
        writer.write(
                MyObjectTransferProtocolFactory.RECEIVE_ALL_CONTACTS(otherUsers)
        );
    }

    private void sendIdToUser(long id) throws IOException{
        writer.write(MyObjectTransferProtocolFactory.RECEIVE_ID(id));
    }

}
