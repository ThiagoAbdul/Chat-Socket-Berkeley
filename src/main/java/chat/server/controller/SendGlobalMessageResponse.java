package chat.server.controller;

import chat.channel.ChannelWriter;
import chat.shared.dto.MessageDTO;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;

public class SendGlobalMessageResponse implements Response{

    private final ChatServer server;

    private final MessageDTO messageDTO;

    public SendGlobalMessageResponse(ChatServer server, MessageDTO messageDTO) {
        this.server = server;
        this.messageDTO = messageDTO;
    }

    @Override
    public void doResponse() {
        server.getConnections().values()
                .stream()
                .unordered()
                .map(connection -> new ChannelWriter(connection.getChannel()))
                .forEach(writer -> {
                    try {
                        writer.write(
                                MyObjectTransferProtocolFactory.RECEIVE_GLOBAL_MESSAGE(messageDTO)
                        );
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
