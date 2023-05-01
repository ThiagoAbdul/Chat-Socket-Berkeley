package chat.client.view;

import javax.swing.*;

public class ChatTextArea extends JTextArea implements ChatComponent {


    public ChatTextArea() {
        setForm();
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(ChatColor.CINZA_CLARO.getCor());
        setForeground(ChatColor.PRETO.getCor());
        setFont(ChatFont.NORMAL.getFont());
    }

    @Override
    public void setForm() {
        setBounds(0, ChatTypeMessagePanel.PADDING, ChatTypeMessagePanel.COMPONENT_WIDTH - ChatButton.BUTTON_WIDTH,
                ChatTypeMessagePanel.COMPONENT_HEIGHT);
    }
}
