package chat.shared.protocol;

import chat.shared.dto.MessageDTO;
import chat.shared.dto.UserDTO;

import java.util.Collection;

public abstract class MyObjectTransferProtocolFactory {

    public static MyObjectTransferProtocol<UserDTO> REGISTER(UserDTO user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.REGISTER.getCode(),
                user
        );
    }

    public static MyObjectTransferProtocol<Long> RECEIVE_ID(Long id){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_ID.getCode(),
                id
        );
    }

    public static MyObjectTransferProtocol<MessageDTO> SEND_PRIVATE_MESSAGE(MessageDTO messageDTO){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.SEND_PRIVATE_MESSAGE.getCode(),
                messageDTO
        );
    }

    public static MyObjectTransferProtocol<MessageDTO> SEND_GLOBAL_MESSAGE(MessageDTO messageDTO){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.SEND_GLOBAL_MESSAGE.getCode(),
                messageDTO
        );
    }

    public static MyObjectTransferProtocol<UserDTO> RECEIVE_NEW_CONTACT(UserDTO user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_NEW_CONTACT.getCode(),
                user);
    }

    public static MyObjectTransferProtocol<Collection<UserDTO>>RECEIVE_ALL_CONTACTS(Collection<UserDTO> contacts){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_ALL_CONTACTS.getCode(),
                contacts
        );
    }

    public static MyObjectTransferProtocol<MessageDTO>RECEIVE_PRIVATE_MESSAGE(MessageDTO messageDTO){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_PRIVATE_MESSAGE.getCode(),
                messageDTO
        );
    }

    public static MyObjectTransferProtocol<MessageDTO>RECEIVE_GLOBAL_MESSAGE(MessageDTO messageDTO){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_GLOBAL_MESSAGE.getCode(),
                messageDTO
        );
    }

}
