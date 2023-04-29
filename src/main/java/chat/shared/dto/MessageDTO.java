package chat.shared.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private String content;
    private final String sender;

    public MessageDTO(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }
}
