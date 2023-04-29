package chat.channel;

import chat.client.ClientKeyHandler;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.function.Consumer;

public class ChannelClient extends ChannelOperation implements Closeable {
    private static String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8081;
    private Selector selector;
    private Iterator<SelectionKey> keysIterator;
    private ChannelReader channelReader;
    private ChannelWriter channelWriter;

    public ChannelClient() {

    }

    public void connectChannel() throws IOException {
        channel = SocketChannel.open(new InetSocketAddress(SERVER_IP, SERVER_PORT));
        channel.configureBlocking(false);
        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_READ);
        this.channelReader = new ChannelReader(this.channel);
        this.channelWriter = new ChannelWriter(this.channel);
    }

    public void observeChannel(ClientKeyHandler handler) throws IOException {
        while (isOpenChannel()){
            forEachSelectedKey(handler);
        }
    }


    public void forEachSelectedKey(ClientKeyHandler handler) throws IOException{

        if(selector.select() != 0){
            keysIterator = selector.selectedKeys().iterator();
            while(keysIterator.hasNext()){
                handler.handleKey(keysIterator.next());
                keysIterator.remove();
            }
        }
    }

    public ChannelReader getChannelReader() {
        return channelReader;
    }

    public ChannelWriter getChannelWriter() {
        return channelWriter;
    }

    @Override
    public void close() throws IOException {
        if(selector != null) selector.close();
        if(channel != null) channel.close();
    }
}
