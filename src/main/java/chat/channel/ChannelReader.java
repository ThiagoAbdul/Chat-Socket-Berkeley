package chat.channel;

import chat.util.io.BufferHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChannelReader extends ChannelOperation{

    private ByteBuffer buffer;

    public ChannelReader(SocketChannel channel){
        this.channel = channel;
    }


    public Object read() throws IOException, ClassNotFoundException {
        return BufferHandler.getObjectFromBuffer(buffer);
    }

    public <T> T read(Class<T> clazz) throws IOException, ClassNotFoundException {
        return BufferHandler.getFromBuffer(this.buffer, clazz);
    }

    public boolean hasContentToRead() throws IOException{
        this.buffer = BufferHandler.channelContentInBuffer(channel);
        return !BufferHandler.isBufferEmpty(this.buffer);
    }
}
