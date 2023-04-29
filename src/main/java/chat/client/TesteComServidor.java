package chat.client;

import chat.model.Mensagem;
import chat.model.Usuario;
import chat.requisicao.ChannelClient;
import chat.shared.CodigoProtocoloDeTransferenciaDeObjeto;
import chat.util.io.BufferHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;


public class TesteComServidor {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Nome do usuario: ");
        String nome = new Scanner(System.in).nextLine();
        Usuario usuario = new Usuario(nome);
        var client = new ChannelClient();
        try{
            client.connectChannel();
            System.out.println(1);
            new Thread( () -> {
                try {
                    client.observeChannel(key -> {
                        if(key.isReadable()){
                            try {
                                ByteBuffer buffer = BufferHandler.channelContentInBuffer(client.getChannel());
                                if(BufferHandler.isBufferEmpty(buffer)) {
                                    return;
                                }
                                else{
                                    Mensagem m = BufferHandler.getFromBuffer(buffer, Mensagem.class);
                                    System.out.println(m);
                                }
                            } catch (IOException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
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
        }
        catch (Exception e){

        }
        while(true){
            Thread.sleep(1000);
            client.write(new Mensagem());
        }

    }
}
