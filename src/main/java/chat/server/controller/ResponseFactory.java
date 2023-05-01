package chat.server.controller;

import chat.exception.UnknowCodeException;
import chat.shared.dto.MessageDTO;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocol;
import chat.shared.protocol.MyObjectTransferprotocolCode;

import java.nio.channels.SocketChannel;
import java.util.Optional;

public class ResponseFactory {

    public static Optional<Response> getOptionalResponse(
            ChatServer server,
            SocketChannel clientChannel,
            MyObjectTransferProtocol<?> motp)
                                                    throws UnknowCodeException {
        int code = motp.CODE;
        if(isUnknownCode(code)){
            throw new UnknowCodeException(code);
        }
        switch (code) {
            case 1 -> {
                UserDTO userDTO = (UserDTO) motp.getObject();
                return Optional.of(new RegisterResponse(server, clientChannel, userDTO));
            }
            case 3 -> {
                MessageDTO messageDTO = (MessageDTO) motp.getObject();
                return Optional.of(new SendPrivateMessageResponse(server, messageDTO));
            }
            case 4 -> {
                MessageDTO messageDTO = (MessageDTO) motp.getObject();
                return Optional.of(new SendGlobalMessageResponse(server, messageDTO));
            }
        }
        return Optional.empty();
    }

    public static Response getEndConnectionResponse(ChatServer server, SocketChannel clientChannel){
        return new EndConnectionResponse(server, clientChannel);
    }

    private static boolean isUnknownCode(int code){
        return code < 0 || code >= MyObjectTransferprotocolCode.values().length;
    }

}
