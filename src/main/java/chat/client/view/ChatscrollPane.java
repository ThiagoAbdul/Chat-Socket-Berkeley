package chat.client.view;

import javax.swing.*;

public class ChatscrollPane extends JScrollPane implements ChatComponent{

    private static final int PADDING = 20;

    public ChatscrollPane(ChatTextArea textArea) {
        super(textArea);
        setForm();
        setBackground(Cores.CINZA_CLARO.getCor());
    }

    @Override
    public void setForm() {
        setBounds(0, PADDING, ChatTypeMessagePanel.COMPONENT_WIDTH + 10,
                ChatTypeMessagePanel.COMPONENT_HEIGHT);
    }
}
