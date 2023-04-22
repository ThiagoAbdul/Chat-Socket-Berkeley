package chat.requisicao;

import chat.shared.ProtocoloDeTransferenciaDeObjeto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Requisicao<T, R>{
    protected static String SERVER_IP = "127.0.0.1";
    protected static final int SERVER_PORT = 8081;

    protected Socket socket;
    protected int codigo;

    Requisicao(int codigo) {
        this.codigo = codigo;
    }


    public ProtocoloDeTransferenciaDeObjeto<R> fazerRequisicao(T objeto) throws IOException, ClassNotFoundException {
        socket = new Socket(SERVER_IP, SERVER_PORT);
        var pto = new ProtocoloDeTransferenciaDeObjeto<T>(codigo, objeto);
        var objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(pto);
        objectOutputStream.flush();
        var objectInputStream = new ObjectInputStream(socket.getInputStream());
        var ptoResponse = (ProtocoloDeTransferenciaDeObjeto<R>)objectInputStream.readObject();
        socket.close();
        return ptoResponse;
    }

    public void fecharConexao(){
        if(socket != null && !socket.isClosed()){
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
