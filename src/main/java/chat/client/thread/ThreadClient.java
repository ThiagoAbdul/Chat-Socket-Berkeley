package chat.client.thread;

import chat.channel.ChannelClient;
import chat.client.ClientKeyHandler;
import chat.model.User;
import chat.service.UserService;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocol;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

import java.io.IOException;

public class ThreadClient extends Thread{

    private ChannelClient client;
    private ClientKeyHandler clientHandler;
    private final User user;

    private final UserService userService;

    public ThreadClient(ChannelClient client, ClientKeyHandler clientHandler, User user) {
        this.client = client;
        this.clientHandler = clientHandler;
        this.user = user;
        this.userService = new UserService();
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
        UserDTO userDTO = userService.userToDTO(user);
        MyObjectTransferProtocol<UserDTO> motp = MyObjectTransferProtocolFactory.REGISTER(userDTO);
        client.getChannelWriter().write(motp);
    }
}
