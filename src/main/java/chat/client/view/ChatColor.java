package chat.client.view;

import java.awt.*;

public enum ChatColor {
    VERDE(100, 130, 30),
    PRETO(30, 30, 30),
    CINZA_ESCURO(37, 37, 38),
    CINZA(51, 51, 51),
    CINZA_CLARO(200, 200, 200),
    BRANCO(255, 255, 255);

    private Color cor;

    ChatColor(int r, int g, int b){
        this.cor = new Color(r, g, b);
    }

    public Color getCor() {
        return cor;
    }
}
