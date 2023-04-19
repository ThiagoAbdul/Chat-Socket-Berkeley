package chat.util.seguranca.criptografia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CriptografiaTest {

    private final String mensagemTeste = "Acai e bom";
    private Criptografia criptografia;
    @BeforeEach
    public void setup(){
        this.criptografia = new Aes();
    }
    @Test
    public void testeCriptografiaMudaMensagem(){

        assertNotEquals(mensagemTeste, criptografia.criptografar(mensagemTeste));
    }

    @Test
    public void testeCriptografiaReversivel(){
        String mensagemCriptografada = criptografia.criptografar(mensagemTeste);
        assertEquals(mensagemTeste, criptografia.descriptografar(mensagemCriptografada));
    }

}