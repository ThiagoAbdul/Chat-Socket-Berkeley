package chat.client;

import chat.channel.ChannelClient;
import chat.channel.ChannelReader;
import chat.handler.KeyHandler;
import chat.shared.protocol.MyObjectTransferProtocol;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public class ClientKeyHandler implements KeyHandler {

    private final ChannelClient client;

    public ClientKeyHandler(ChannelClient client) {
        this.client = client;
    }
    @Override
    public void handleKey(SelectionKey key) throws IOException {
        if(key.isReadable()){
            try {
                ChannelReader reader = client.getChannelReader();
                if(reader.hasContentToRead()){
                    MyObjectTransferProtocol<?> motp = reader.read(MyObjectTransferProtocol.class);
                    System.out.println(motp.getObject());
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
