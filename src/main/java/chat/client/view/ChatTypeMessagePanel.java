package chat.client.view;

import javax.swing.*;

public class ChatTypeMessagePanel extends JPanel implements ChatComponent {
    static final int COMPONENT_HEIGHT = 140;
    private final ChatscrollPane scroll;
    static final int COMPONENT_WIDTH = ChatWindow.LARGURA_JANELA - ChatContactsPanel.LARGURA_PAINEL;
    public ChatTypeMessagePanel() {
        setLayout(null);
        setForm();
        setBackground(Cores.CINZA_ESCURO.getCor());
        scroll = new ChatscrollPane(new ChatTextArea());
        add(scroll);
    }

    @Override
    public void setForm() {
        setBounds(ChatContactsPanel.LARGURA_PAINEL,
                ChatWindow.ALTURA_JANELA - COMPONENT_HEIGHT,
                COMPONENT_WIDTH,
                COMPONENT_HEIGHT);
    }
}
