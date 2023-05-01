package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.model.Connection;
import chat.shared.dto.MessageDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;

public class SendPrivateMessageResponse implements Response{

    private final ChatServer server;
    private final MessageDTO messageDTO;

    public SendPrivateMessageResponse(ChatServer server, MessageDTO messageDTO) {
        this.server = server;
        this.messageDTO = messageDTO;
    }

    @Override
    public void doResponse() throws IOException{
        Connection receiverConnection = server.getConnections().get(messageDTO.getReceiverId());
        if(foundConnection(receiverConnection)){
            ChannelWriter writer = new ChannelWriter(receiverConnection.getChannel());
            var motp = MyObjectTransferProtocolFactory.RECEIVE_PRIVATE_MESSAGE(messageDTO);
            writer.write(motp);
        }
        else{
            // TODO
        }
    }

    private boolean foundConnection(Connection connection){
        return connection != null;
    }

}
