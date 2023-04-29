package chat.shared.protocol;

import chat.model.Message;
import chat.model.User;
import chat.shared.dto.MessageDTO;
import chat.shared.dto.UserDTO;

public abstract class MyObjectTransferProtocolFactory {

    public static MyObjectTransferProtocol<UserDTO> REGISTER(UserDTO user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.REGISTER.getCode(),
                user
        );
    }

    public static MyObjectTransferProtocol<MessageDTO> SEND_PRIVATE_MESSAGE(MessageDTO messageDTO){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.SEND_PRIVATE_MESSAGE.getCode(),
                messageDTO
        );
    }

    public static MyObjectTransferProtocol<UserDTO> RECEIVE_NEW_CONTACT(UserDTO user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_NEW_CONTACT.getCode(),
                user);
    }

}
