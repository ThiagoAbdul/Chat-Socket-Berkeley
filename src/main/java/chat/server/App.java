package chat.server;

import chat.server.controller.ChatServer;
import lombok.extern.log4j.Log4j2;

import java.io.Closeable;
import java.io.IOException;

@Log4j2
public class App {

    public static void main(String[] args) {
        ChatServer server = null;
        try {
            server = ChatServer.getInstance();
        } catch (IOException e) {
            fecharConexao(server);
            throw new RuntimeException(e); // Deu ruim, encerrou o programa
        }
        // Se deu bom

            log.info("Servidor esperando conexões");
            try {
                server.listen();

                log.info("Cliente conectado");

            }
            catch (IOException e){
                log.info(e.getMessage());
                fecharConexao(server);
            }

    }

    static void fecharConexao(Closeable conexao){
        if (conexao != null){
            try {
                conexao.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
