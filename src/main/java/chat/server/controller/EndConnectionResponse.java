package chat.server.controller;

import chat.exception.UnregisteredChannelException;
import chat.model.Connection;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Optional;

public class EndConnectionResponse implements Response{

    private final ChatServer server;
    private final SocketChannel clientChannel;

    public EndConnectionResponse(ChatServer server, SocketChannel clientChannel) {
        this.server = server;
        this.clientChannel = clientChannel;
    }

    @Override
    public void doResponse() throws IOException{
        clientChannel.close();
        Long connectionId = getConnectionIdByChannel(clientChannel)
                .orElseThrow(UnregisteredChannelException::new);
        server.getConnections().remove(connectionId);
        // TODO
        // Precisa pegar a key do user removido e enviar para o cliente saber que está offline

    }

    private Optional<Long> getConnectionIdByChannel(SocketChannel clientChannel){
        SocketChannel currentChannel;
        for(Map.Entry<Long, Connection>entry: server.getConnections().entrySet()){
            currentChannel = entry.getValue().getChannel();
            if(clientChannel.equals(currentChannel)){
                return Optional.of(entry.getKey());
            }
        }
        return Optional.empty();
    }

}
