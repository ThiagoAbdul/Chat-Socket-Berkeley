package chat.shared;

import chat.model.Message;
import chat.model.User;

public abstract class MyObjectTransferProtocolFactory {

    public static MyObjectTransferProtocol<User> REGISTER(User user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.REGISTER.getCode(),
                user
        );
    }

    public static MyObjectTransferProtocol<Message> SEND_PRIVATE_MESSAGE(Message message){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.SEND_PRIVATE_MESSAGE.getCode(),
                message
        );
    }

    public static MyObjectTransferProtocol<User> RECEIVE_NEW_CONTACT(User user){
        return new MyObjectTransferProtocol<>(
                MyObjectTransferprotocolCode.RECEIVE_NEW_CONTACT.getCode(),
                user);
    }

}
