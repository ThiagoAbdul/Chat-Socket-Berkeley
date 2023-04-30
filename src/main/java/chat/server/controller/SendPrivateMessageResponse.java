package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.service.MessageService;
import chat.shared.dto.MessageDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class SendPrivateMessageResponse implements Response{

    private final ChatServer server;
    private final MessageDTO messageDTO;

    public SendPrivateMessageResponse(ChatServer server, MessageDTO messageDTO) {
        this.server = server;
        this.messageDTO = messageDTO;
    }

    @Override
    public void doResponse() {
        Connection receiverConnection = server.getConnections().get(messageDTO.getReceiverId());
        if(foundConnection(receiverConnection)){
            ChannelWriter writer = new ChannelWriter(receiverConnection.getChannel());
            try {
                var motp = MyObjectTransferProtocolFactory.RECEIVE_PRIVATE_MESSAGE(messageDTO);
                writer.write(motp);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            // TODO
        }
    }

    private boolean foundConnection(Connection connection){
        return connection != null;
    }

}
