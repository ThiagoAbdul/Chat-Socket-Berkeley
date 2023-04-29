package chat.server.controller;

import chat.model.Connection;
import lombok.extern.log4j.Log4j2;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@Log4j2
public class ChatServer implements Closeable {

    public static final int SERVER_PORT = 8081;
    public static final String SERVER_IP = "127.0.0.1";
    private static final Collection<Connection> connections = new HashSet<>();

    private static ChatServer instance;
    private final ServerSocketChannel serverChannel;
    private final Selector selector;
    private Iterator<SelectionKey> keysIterator;

    private final KeyController keyController = new KeyControllerImpl(this);

    private ChatServer() throws IOException {
        this.serverChannel = ServerSocketChannel.open();
        this.selector = Selector.open();

    }

    public static ChatServer getInstance() throws IOException {
        if(instance == null){
            instance = new ChatServer();
        }
        return instance;
    }

    public void listen() throws IOException {
        this.serverChannel.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
        this.serverChannel.configureBlocking(false);
        this.serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
        while (serverChannel.isOpen()){
            keysIterator = selector.selectedKeys().iterator();
            forEachSelectedKey(keyController); // TODO
        }
    }

    private void forEachSelectedKey(KeyController keyController) throws IOException {
        if(hasSelectedChannels()){
            keysIterator = selector.selectedKeys().iterator();
            while (keysIterator.hasNext()){
                keyController.handleKey(keysIterator.next());
                keysIterator.remove();
            }
        }
    }

    private boolean hasSelectedChannels() throws IOException {
        return selector.select() != 0;
    }

    Collection<Connection> getConnections(){
        return connections;
    }

    public ServerSocketChannel getServerChannel(){
        return serverChannel;
    }

    public Selector getSelector(){
        return selector;
    }

    public SocketChannel acceptClient() throws IOException {
        return serverChannel.accept();
    }

    @Override
    public void close() throws IOException {
        this.selector.close();
        this.serverChannel.close();
    }
}
