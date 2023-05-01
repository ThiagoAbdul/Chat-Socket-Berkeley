package chat.client.view;

import javax.swing.*;
import java.awt.*;

public abstract class ChatButton extends JButton implements ChatComponent {

    protected static final int BUTTON_WIDTH = 100;
    protected static final int BUTTON_HEIGHT = 45;
    public ChatButton(String text) {
        super(text);
        setFont(ChatFont.LARGE.getFont());
        setBackground(ChatColor.VERDE.getCor());
        setForeground(ChatColor.BRANCO.getCor());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
