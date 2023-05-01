package chat.client.view;

import java.awt.*;

public enum ChatFont {

    NORMAL(new Font(Font.SANS_SERIF, Font.BOLD, 12)),
    LARGE(new Font(Font.SANS_SERIF, Font.BOLD, 16));


    private Font font;

    ChatFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
