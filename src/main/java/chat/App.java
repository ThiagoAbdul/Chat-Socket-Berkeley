package chat;

import chat.model.Usuario;
import chat.shared.ProtocoloDeTransferenciaDeObjeto;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class App{ // Teste com servidor
    public static void main(String[] args) {
        int SERVER_PORT = 8081;
        String SERVER_IP = "127.0.0.1";
        Usuario usuario = new Usuario(1L, "Hello world");
        var pto = new ProtocoloDeTransferenciaDeObjeto(2, usuario);
        try(Socket socket = new Socket(SERVER_IP, SERVER_PORT)){

            var objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(pto);
            objectOutputStream.flush();
            var objectInputStream = new ObjectInputStream(socket.getInputStream());
            var pto2 = (ProtocoloDeTransferenciaDeObjeto)objectInputStream.readObject();
            System.out.println(pto2.CODIGO);
            while (true){ }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}