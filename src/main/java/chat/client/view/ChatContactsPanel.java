package chat.client.view;

import javax.swing.*;

public class ChatContactsPanel extends JPanel implements ChatComponent {

    static final int LARGURA_PAINEL = 280;
    public ChatContactsPanel() {
        setForm();
        setBackground(ChatColor.CINZA.getCor());
    }

    @Override
    public void setForm() {
        setBounds(0, 0, LARGURA_PAINEL, ChatWindow.ALTURA_JANELA);
    }
}
