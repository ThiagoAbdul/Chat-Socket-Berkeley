package chat.handler;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface KeyHandler {

    void handleKey(SelectionKey key) throws IOException;
}
