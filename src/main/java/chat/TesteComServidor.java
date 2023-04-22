package chat;

import chat.model.Usuario;
import chat.requisicao.Requisicoes;
import chat.shared.CodigoProtocoloDeTransferenciaDeObjeto;

import java.util.Scanner;


public class TesteComServidor {

    public static void main(String[] args) {
        System.out.println("Nome do usuario: ");
        String nome = new Scanner(System.in).nextLine();
        Usuario usuario = new Usuario(nome);
        var requisicaoDeRegistro = Requisicoes.REGISTRO;
        try{
            var ptoResponse = requisicaoDeRegistro.fazerRequisicao(usuario);
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
            }
        }
        catch (Exception e){
            requisicaoDeRegistro.fecharConexao();
            e.printStackTrace();
        }
    }
}
