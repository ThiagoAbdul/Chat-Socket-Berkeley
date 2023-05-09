package chat.server.controller;

import chat.channel.ChannelReader;
import chat.exception.UnknowCodeException;
import chat.handler.KeyHandler;
import chat.shared.protocol.MyObjectTransferProtocol;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Optional;

@Log4j2
public class ServerKeyHandler implements KeyHandler {

    private final ChatServer server;

    public ServerKeyHandler(ChatServer server) {
        this.server = server;
    }

    @Override
    public void handleKey(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
           configureClientConnection(server.acceptClient());
            // TODO
            log.info("Cliente aceito");
        }
        else if(key.isReadable()){
            SocketChannel clientChannel = (SocketChannel) key.channel();
            if(clientChannel.isOpen()){
                ChannelReader reader = new ChannelReader(clientChannel);
                if(reader.hasContentToRead()){
                    try {
                        MyObjectTransferProtocol<?> motp = reader.read(MyObjectTransferProtocol.class);
                        Optional<ServerResponse> response = ServerResponseFactory.getOptionalResponse(server, clientChannel, motp);
                        if(response.isPresent()){
                            response.get().doResponse();
                        }
                    } catch (ClassNotFoundException | UnknowCodeException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    log.info("Nothing to read");
                    ServerResponse serverResponse = ServerResponseFactory.getEndConnectionResponse(server, clientChannel);
                    serverResponse.doResponse();
                }
            }
        }
    }


    private void configureClientConnection(SocketChannel clientChannel) throws IOException {
        clientChannel.configureBlocking(false);
        clientChannel.register(server.getSelector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }
}
