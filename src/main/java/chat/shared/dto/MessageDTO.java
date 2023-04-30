package chat.shared.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

    private String content;

    private long senderId;
    private final String senderName;

    private final long receiverId;

    public MessageDTO(String content, String senderName, long receiverId) {
        this.content = content;
        this.senderName = senderName;
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderName() {
        return senderName;
    }

    public long getReceiverId() {
        return receiverId;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", senderName, content);
    }
}
