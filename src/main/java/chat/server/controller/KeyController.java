package chat.server.controller;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface KeyController {

    void handleKey(SelectionKey key) throws IOException;
}
