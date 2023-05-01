package chat.server;

import chat.server.controller.ChatServer;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class App {

    public static void main(String[] args) {
        try (ChatServer server = ChatServer.getInstance()){
            log.info("Servidor esperando conexões");
            server.listen();
            log.info("Cliente conectado");
        } catch (IOException e) {
            log.info(e.getMessage());
            System.exit(1); // Deu ruim, encerrou o programa
        }
    }


}
