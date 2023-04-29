package chat.server.controller;

import chat.model.Message;
import chat.service.MessageService;
import chat.shared.dto.MessageDTO;

public class SendPrivateMessageResponse implements Response{

    private final ChatServer server;
    private final MessageDTO messageDTO;
    private final MessageService messageService;

    public SendPrivateMessageResponse(ChatServer server, MessageDTO messageDTO) {
        this.server = server;
        this.messageDTO = messageDTO;
        this.messageService = new MessageService();
    }

    @Override
    public void doResponse() {
        messageService.decryptMessageDTO(messageDTO);
        System.out.println("-" + messageDTO.getSender() + ": " + messageDTO.getContent());
    }
}
