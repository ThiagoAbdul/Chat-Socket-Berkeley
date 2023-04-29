package chat.channel;

import chat.util.io.BufferHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChannelWriter extends ChannelOperation{

    public ChannelWriter(SocketChannel channel){
        this.channel = channel;
    }

    public <T> void write(T t) throws IOException {
        ByteBuffer buffer = BufferHandler.objectInBuffer(t);
        channel.write(buffer);
    }
}
