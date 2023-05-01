package chat.client.view;

import javax.swing.*;
import java.awt.*;

public class ChatTextArea extends JTextArea implements ChatComponent {

    private static final int PADDING = 20;

    public ChatTextArea() {
        setForm();
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Cores.CINZA_CLARO.getCor());
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 12);
        setForeground(Cores.PRETO.getCor());
        setFont(font);
    }

    @Override
    public void setForm() {
        setBounds(0, PADDING, ChatTypeMessagePanel.COMPONENT_WIDTH,
                ChatTypeMessagePanel.COMPONENT_HEIGHT);
    }
}
