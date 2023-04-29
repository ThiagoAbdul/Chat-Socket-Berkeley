package chat.requisicao;

import chat.util.io.BufferHandler;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.function.Consumer;

public class ChannelClient implements Closeable {
    protected static String SERVER_IP = "127.0.0.1";
    protected static final int SERVER_PORT = 8081;
    protected SocketChannel channel;
    protected Selector selector;

    protected Iterator<SelectionKey> keysIterator;

    public ChannelClient() {

    }


    public void connectChannel() throws IOException {
        channel = SocketChannel.open(new InetSocketAddress(SERVER_IP, SERVER_PORT));
        channel.configureBlocking(false);
        selector = Selector.open();
        channel.register(selector, SelectionKey.OP_READ);
    }

    public void observeChannel(Consumer<SelectionKey> consumer) throws IOException {
        while (isOpenChannel()){
            forEachSelectedKey(consumer);
        }
    }



    public SocketChannel getChannel(){
        return this.channel;
    }

    public boolean isOpenChannel(){
        if(this.channel != null){
            return this.channel.isOpen();
        }
        return false;
    }

    public void forEachSelectedKey(Consumer<SelectionKey> consumer) throws IOException{

        if(selector.select() != 0){
            keysIterator = selector.selectedKeys().iterator();
            while(keysIterator.hasNext()){
                consumer.accept(keysIterator.next());
                keysIterator.remove();
            }
        }
    }

    public <T> void write(T t) throws IOException {
        ByteBuffer buffer = BufferHandler.objectInBuffer(t);
        channel.write(buffer);
    }

    @Override
    public void close() throws IOException {
        if(selector != null) selector.close();
        if(channel != null) channel.close();
    }
}
