package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.shared.dto.MessageDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;

public class SendGlobalMessageResponse implements ServerResponse {

    private final ChatServer server;

    private final MessageDTO messageDTO;

    public SendGlobalMessageResponse(ChatServer server, MessageDTO messageDTO) {
        this.server = server;
        this.messageDTO = messageDTO;
    }

    @Override
    public void doResponse() throws IOException{
        var connections = server.getConnections().values();
        ChannelWriter writer;
        for(Connection connection: connections){
            writer = new ChannelWriter(connection.getChannel());
            writer.write(
                    MyObjectTransferProtocolFactory.RECEIVE_GLOBAL_MESSAGE(messageDTO)
            );
        }
    }
}
