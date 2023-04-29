package chat.util.security.crypto;

public interface Crypto {
	
	public abstract String crypt(String mensagem);
	
	public abstract String decrypt(String mensagem);

}
