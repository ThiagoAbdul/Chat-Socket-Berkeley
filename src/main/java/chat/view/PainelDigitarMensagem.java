package chat.view;

import javax.swing.*;

public class PainelDigitarMensagem extends Painel {
    static final int ALTURA_PAINEL = 140;
    public PainelDigitarMensagem() {
        setForma();
        setBackground(Cores.CINZA_ESCURO.getCor());
    }

    @Override
    public void setForma() {
        setBounds(PainelContatos.LARGURA_PAINEL,
                Janela.ALTURA_JANELA - ALTURA_PAINEL,
                Janela.LARGURA_JANELA - PainelContatos.LARGURA_PAINEL,
                ALTURA_PAINEL);
    }
}
