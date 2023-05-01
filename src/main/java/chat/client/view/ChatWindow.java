package chat.client.view;

import javax.swing.JFrame;
import java.awt.*;

public class ChatWindow extends JFrame{
    static final int LARGURA_JANELA = 960;
    static final int ALTURA_JANELA = 640;
    final ChatContactsPanel painelContatos = new ChatContactsPanel();
    final ChatTypeMessagePanel painelDigitarMensagem= new ChatTypeMessagePanel();

    public ChatWindow() throws HeadlessException {

        setTitle("Chat"); // Nome temporário
        setSize(LARGURA_JANELA, ALTURA_JANELA);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(Cores.PRETO.getCor());
        getContentPane().add(painelContatos);
        getContentPane().add(painelDigitarMensagem);
        setVisible(true);
    }

}
