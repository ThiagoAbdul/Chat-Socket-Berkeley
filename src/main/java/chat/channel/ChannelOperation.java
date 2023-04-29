package chat.channel;

import java.nio.channels.SocketChannel;

public abstract class ChannelOperation {

    protected SocketChannel channel;

    public SocketChannel getChannel(){
        return this.channel;
    }

    public boolean isOpenChannel(){
        if(this.channel != null){
            return this.channel.isOpen();
        }
        return false;
    }

}
