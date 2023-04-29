package chat.client;

import chat.channel.ChannelClient;
import chat.client.thread.ThreadClient;
import chat.model.Message;
import chat.model.User;
import chat.shared.MyObjectTransferProtocol;
import chat.shared.MyObjectTransferProtocolFactory;

import java.io.IOException;
import java.util.Scanner;


public class TesteComServidor {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Nome do usuario: ");
        String nome = new Scanner(System.in).nextLine();
        User user = new User(nome);
        var client = new ChannelClient();
        ClientKeyHandler clientHandler = new ClientKeyHandler(client);
        var thread = new ThreadClient(client, clientHandler, user);
        thread.start();
            /*var ptoResponse = requisicaoDeRegistro.fazerRequisicao(usuario);
            if (ptoResponse.CODIGO == CodigoProtocoloDeTransferenciaDeObjeto.OK.getCodigo()){
                System.out.println("OK");
                var requisicaoDeDescobertaDeUsuarios = Requisicoes.DESCOBRIR_OUTROS_USUARIOS;
                long idUsuario = ptoResponse.getObjeto();
                try{
                    var ptoResponse2 = requisicaoDeDescobertaDeUsuarios.fazerRequisicao(idUsuario);
                    (ptoResponse2.getObjeto())
                            .forEach(System.out::println);
                }
                catch (Exception e){
                    requisicaoDeDescobertaDeUsuarios.fecharConexao();
                    e.printStackTrace();
                }
            }*/
        Scanner scan = new Scanner(System.in);
        while(true){
            String content = scan.nextLine();
            MyObjectTransferProtocol<Message> motp = MyObjectTransferProtocolFactory
                    .SEND_PRIVATE_MESSAGE(new Message(user, content));
            client.getChannelWriter().write(motp);
        }

    }
}
