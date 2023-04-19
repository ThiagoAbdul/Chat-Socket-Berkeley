package chat.util.seguranca.criptografia;

public interface Criptografia {
	
	public abstract String criptografar(String mensagem);
	
	public abstract String descriptografar(String mensagem);

}
