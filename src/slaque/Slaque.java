package slaque;

import java.util.HashMap;
import java.util.Map;

public class Slaque {

    private Map<String, Usuario> usuarios;
    private Map<String, Canal> canais;

    public Slaque() {
        this.usuarios = new HashMap<>();
        this.canais = new HashMap<>();
    }

    public void cadastrarUsuario(String nome, String email) {
        this.usuarios.put(email, new Usuario(nome, email));
    }

    public void cadastrarCanal(String nome) {
        this.canais.put(nome, new Canal(nome));
    }

    public void entrarEmCanal(String nomeCanal, String emailUsuario) {
        this.canais.get(nomeCanal).adicionarUsuario(this.usuarios.get(emailUsuario));
    }

    public void enviarMensagem(String nomeCanal, String emailUsuario, String mensagem) {
        this.canais.get(nomeCanal).enviarMensagem(emailUsuario, mensagem);
    }

    public void sairDoCanal(String nomeCanal, String emailUsuario) {
        this.canais.get(nomeCanal).removerUsuario(emailUsuario);
    }

    public String imprimeCanal(String nomeCanal) {
        return this.canais.get(nomeCanal).toString();
    }
}
