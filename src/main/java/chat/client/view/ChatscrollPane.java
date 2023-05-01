package chat.client.view;

import javax.swing.*;

public class ChatscrollPane extends JScrollPane implements ChatComponent{


    public ChatscrollPane(ChatTextArea textArea) {
        super(textArea);
        setForm();
        setBackground(ChatColor.CINZA_CLARO.getCor());
    }

    @Override
    public void setForm() {
        setBounds(0, ChatTypeMessagePanel.PADDING, ChatTypeMessagePanel.COMPONENT_WIDTH + 5 - ChatButton.BUTTON_WIDTH,
                ChatTypeMessagePanel.COMPONENT_HEIGHT - 55);
    }
}
