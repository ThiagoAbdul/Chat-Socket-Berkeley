package chat.util.seguranca.criptografia;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Aes implements Criptografia{

    private static final String PASS_PHRASE = "1234567789abcdef";
    private static final String ALGORITMO = "AES";
    private static final SecretKey chave = gerarChaveSecreta();
    private static final Cipher cifra = iniciarCifra();
    private static final int TAMANHO_DA_CHAVE = 128;

    private static final SecretKey gerarChaveSecreta(){
        return new SecretKeySpec(PASS_PHRASE.getBytes(), ALGORITMO);
    }

    private static final Cipher iniciarCifra(){
        try {
            Cipher cifra = Cipher.getInstance(ALGORITMO);
            return cifra;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String criptografar(String mensagem) {

        try {
            cifra.init(Cipher.ENCRYPT_MODE, chave);
            byte[] mensagemCriptografada = cifra.doFinal(mensagem.getBytes());
            byte[] bytes = Base64.getEncoder().encode(mensagemCriptografada);
            return new String(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String descriptografar(String mensagem) {
        try {
            cifra.init(Cipher.DECRYPT_MODE, chave);
            byte[] bytes = Base64.getDecoder().decode(mensagem);
            byte[] mensagemDescriptografada = cifra.doFinal(bytes);
            return new String(mensagemDescriptografada);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
