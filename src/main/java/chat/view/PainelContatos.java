package chat.view;

import javax.swing.*;

public class PainelContatos extends Painel {

    static final int LARGURA_PAINEL = 280;
    public PainelContatos() {
        setForma();
        setBackground(Cores.CINZA.getCor());
    }

    @Override
    public void setForma() {
        setBounds(0, 0, LARGURA_PAINEL, Janela.ALTURA_JANELA);
    }
}
