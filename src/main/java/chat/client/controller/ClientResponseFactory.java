package chat.client.controller;

import chat.shared.protocol.MyObjectTransferProtocol;

import java.util.Optional;

public abstract class ClientResponseFactory {

    public static Optional<ClientResponse> getClientResponse(MyObjectTransferProtocol<?> motp){
        int code = motp.CODE;
        switch (code){
            case 2 -> {

            }
            case 5 -> {

            }
            case 6 -> {

            }
            case 7 -> {

            }
            case 8 -> {

            }
        }
        return Optional.empty(); // TODO
    }

}
