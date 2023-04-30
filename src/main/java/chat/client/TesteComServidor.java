package chat.client;

import chat.channel.ChannelClient;
import chat.client.thread.ThreadClient;
import chat.model.Message;
import chat.model.User;
import chat.service.MessageService;
import chat.shared.dto.MessageDTO;
import chat.shared.dto.UserDTO;
import chat.shared.protocol.MyObjectTransferProtocol;
import chat.shared.protocol.MyObjectTransferProtocolFactory;

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
        Scanner scan = new Scanner(System.in);
        MessageService messageService = new MessageService();
        while(true){
            String content = scan.nextLine();
            UserDTO receiver = new UserDTO("");
            receiver.setId(1L);
            var messageDTO = messageService.messageToDTO(new Message(user, content, receiver));
            // messageService.cryptoMessageDTO(messageDTO);
            MyObjectTransferProtocol<MessageDTO> motp = MyObjectTransferProtocolFactory
                    .SEND_GLOBAL_MESSAGE(messageDTO);
            client.getChannelWriter().write(motp);
        }

    }
}
