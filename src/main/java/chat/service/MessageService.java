package chat.service;

import chat.model.Message;
import chat.shared.dto.MessageDTO;
import chat.util.security.crypto.Aes;

public class MessageService {

    private final Aes algorythmAes;

    public MessageService() {
        this.algorythmAes = new Aes();
    }

    public MessageDTO messageToDTO(Message message){
        return new MessageDTO(
                message.getContent(),
                message.getSender().getName(),
                message.getReceiver().getId()
        );
    }

    public void cryptoMessageDTO(MessageDTO messageDTO){
        messageDTO.setContent(algorythmAes.crypt(messageDTO.getContent()));
    }

    public void decryptMessageDTO(MessageDTO messageDTO) {
        messageDTO.setContent(algorythmAes.decrypt(messageDTO.getContent()));
    }
}
