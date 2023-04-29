package chat.server.controller;

import chat.model.Connection;
import chat.model.Mensagem;
import chat.util.io.BufferHandler;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

@Log4j2
public class KeyControllerImpl implements KeyController{

    private final ChatServer server;

    public KeyControllerImpl(ChatServer server) {
        this.server = server;
    }

    @Override
    public void handleKey(SelectionKey key) throws IOException {
        if(key.isAcceptable()){
           Connection newConnection = createConnection(server.acceptClient());
            server.getConnections().add(newConnection);
            log.info("Cliente aceito");
        }
        else if(key.isReadable()){
            log.info("Readable sim");
            SocketChannel clientChannel = (SocketChannel) key.channel();
            if(clientChannel.isOpen()){
                ByteBuffer buffer = BufferHandler.channelContentInBuffer(clientChannel);
                if(BufferHandler.isBufferEmpty(buffer)){
                    log.info("Nothing to read");
                    clientChannel.close();
                    server.getConnections().remove(new Connection(clientChannel)); // TODO
                }
                else{
                    try { // TODO
                        Mensagem message = BufferHandler.getFromBuffer(buffer, Mensagem.class);
                        System.out.println(message);
                        broadcast(message);
                    }
                    catch (ClassNotFoundException e){
                        log.info(e.getMessage());
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }



    private void broadcast(Object o) throws IOException {
        ByteBuffer buffer = BufferHandler.objectInBuffer(o);
        for (Connection connection: server.getConnections()){
            connection.getChannel().write(buffer);
        }
    }





    private Connection createConnection(SocketChannel clientChannel) throws IOException {
        clientChannel.configureBlocking(false);
        clientChannel.register(server.getSelector(), SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        return new Connection(clientChannel);
    }
}
