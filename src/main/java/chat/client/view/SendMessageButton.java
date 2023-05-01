package chat.client.view;

public class SendMessageButton extends ChatButton{
    public SendMessageButton() {
        super("Enviar");
        setForm();
    }

    @Override
    public void setForm() {
        setBounds(ChatTypeMessagePanel.COMPONENT_WIDTH - BUTTON_WIDTH,
                ChatTypeMessagePanel.PADDING, BUTTON_WIDTH,
                BUTTON_HEIGHT);
    }
}
