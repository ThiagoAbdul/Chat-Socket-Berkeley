package chat;

import chat.model.Usuario;
import chat.shared.ProtocoloDeTransferenciaDeObjeto;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.LinkPermission;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        int SERVER_PORT = 8081;
        String SERVER_IP = "127.0.0.1";
        Usuario usuario = new Usuario(1L, "Hello world");
        var pto = new ProtocoloDeTransferenciaDeObjeto(1, usuario);
        try(Socket socket = new Socket(SERVER_IP, SERVER_PORT)){

            var objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(pto);
            objectOutputStream.flush();
            new Scanner(System.in).nextLine();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}