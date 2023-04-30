package chat.server.controller;

import chat.exception.UnknowCodeException;
import chat.shared.dto.MessageDTO;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocol;

import java.nio.channels.SocketChannel;

public class ResponseFactory {

    public static Response getResponse(
            ChatServer server,
            SocketChannel clientChannel,
            MyObjectTransferProtocol<?> motp)
                                                    throws UnknowCodeException {

        switch (motp.CODE) {
            case 1 -> {
                UserDTO userDTO = (UserDTO) motp.getObject();
                return new RegisterResponse(server, clientChannel, userDTO);
            }
            case 3 -> {
                MessageDTO messageDTO = (MessageDTO) motp.getObject();
                return new SendPrivateMessageResponse(server, messageDTO);
            }
            case 4 -> {
                MessageDTO messageDTO = (MessageDTO) motp.getObject();
                return new SendGlobalMessageResponse(server, messageDTO);
            }
        }
        throw new UnknowCodeException(motp.CODE);
    }

}
