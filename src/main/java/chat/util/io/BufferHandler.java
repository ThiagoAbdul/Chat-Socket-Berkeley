package chat.util.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class BufferHandler {

    public static ByteBuffer channelContentInBuffer(SocketChannel clientChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        clientChannel.read(buffer);
        return buffer;
    }

    public static ByteBuffer objectInBuffer(Object o) throws IOException{
        var baos = new ByteArrayOutputStream();
        var oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.flush();
        ByteBuffer buffer = ByteBuffer.wrap(baos.toByteArray());
        baos.close();
        oos.close();
        return  buffer;
    }

    public static boolean isBufferEmpty(ByteBuffer buffer){
        return buffer.get(0) == 0;
    }

    public static <T> T getFromBuffer(ByteBuffer buffer, Class<T> clazz) throws IOException, ClassNotFoundException {
        var objectInputStream = new ObjectInputStream(
                new ByteArrayInputStream(buffer.array())
        );
        T t = clazz.cast(objectInputStream.readObject());
        objectInputStream.close();
        return t;
    }
}
