package chat.server.controller;

import chat.exception.UnknowCodeException;
import chat.model.Message;
import chat.model.User;
import chat.shared.MyObjectTransferProtocol;

import java.nio.channels.SocketChannel;

public class ResponseFactory {

    public static Response getResponse(
            ChatServer server,
            SocketChannel clientChannel,
            MyObjectTransferProtocol<?> motp)
                                                    throws UnknowCodeException {

        switch (motp.CODE) {
            case 1 -> {
                return null; // TODO
            }
            case 2 -> {
                User user = (User) motp.getObject();
                return new RegisterResponse(server, clientChannel, user);
            }
            case 3 -> {
                Message message = (Message) motp.getObject();
                return new SendPrivateMessageResponse(server, message);
            }
            case 4 -> {
                return null; // TODO
            }
        }
        throw new UnknowCodeException(motp.CODE);
    }

}
