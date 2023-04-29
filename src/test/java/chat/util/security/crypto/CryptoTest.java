package chat.util.security.crypto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoTest {

    private final String mensagemTeste = "Acai e bom";
    private Crypto crypto;
    @BeforeEach
    public void setup(){
        this.crypto = new Aes();
    }
    @Test
    public void testeCriptografiaMudaMensagem(){

        assertNotEquals(mensagemTeste, crypto.crypt(mensagemTeste));
    }

    @Test
    public void testeCriptografiaReversivel(){
        String mensagemCriptografada = crypto.crypt(mensagemTeste);
        assertEquals(mensagemTeste, crypto.decrypt(mensagemCriptografada));
    }

}