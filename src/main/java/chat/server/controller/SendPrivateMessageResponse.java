package chat.server.controller;

import chat.model.Message;

public class SendPrivateMessageResponse implements Response{

    private final ChatServer server;
    private final Message message;

    public SendPrivateMessageResponse(ChatServer server, Message message) {
        this.server = server;
        this.message = message;
    }

    @Override
    public void doResponse() {
        System.out.println(message);
    }
}
