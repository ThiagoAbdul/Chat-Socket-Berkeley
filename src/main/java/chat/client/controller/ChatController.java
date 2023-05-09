package chat.client.controller;

import chat.client.view.TelaChat;
import chat.client.view.TelaInicial;
import chat.model.User;

public class ChatController {

    private User usuario;

    private final TelaInicial telaInicial;
    private TelaChat telaChat;

    public ChatController(TelaInicial telaInicial) {
        this.telaInicial = telaInicial;
    }

    public void logar(){
        if(foiInseridoNomeDeUsuario()){
            this.usuario = new User(telaInicial.getNomeDeUsuario());
            telaChat = criarTelaChat();
            telaInicial.dispose();
            telaChat.iniciar();
        }
        else{
            telaInicial.marcarErroDePreenchimento();
        }

    }

    private boolean foiInseridoNomeDeUsuario(){
        return !telaInicial.getNomeDeUsuario().isBlank();
    }

    private TelaChat criarTelaChat(){
        return new TelaChat(this);
    }

    public String getNomeDoUsuario(){
        return telaInicial.getNomeDeUsuario();
    }
}
