package chat.client.thread;

import chat.channel.ChannelClient;
import chat.client.ClientKeyHandler;
import chat.handler.KeyHandler;
import chat.model.User;
import chat.shared.MyObjectTransferProtocol;
import chat.shared.MyObjectTransferProtocolFactory;
import chat.shared.MyObjectTransferprotocolCode;

import java.io.IOException;

public class ThreadClient extends Thread{

    private ChannelClient client;
    private ClientKeyHandler clientHandler;
    private final User user;

    public ThreadClient(ChannelClient client, ClientKeyHandler clientHandler, User user) {
        this.client = client;
        this.clientHandler = clientHandler;
        this.user = user;
    }

    @Override
    public void run(){
        try {
            client.connectChannel();
            this.requestRegister();
            client.observeChannel(clientHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void requestRegister() throws IOException {
        MyObjectTransferProtocol<User> motp = MyObjectTransferProtocolFactory.REGISTER(user);
        client.getChannelWriter().write(motp);
    }
}
