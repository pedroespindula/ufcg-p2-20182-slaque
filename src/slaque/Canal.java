package slaque;

import java.util.*;

public class Canal {
    private final String nome;
    private final List<Mensagem> mensagens;
    private Map<String, Usuario> usuarios;

    public Canal(String nome) {
       this.nome = nome;
       this.mensagens = new ArrayList<>();
       this.usuarios = new HashMap<>();
    }

    public void adicionarUsuario(Usuario usuario) {
       this.usuarios.put(usuario.getEmail(), usuario);
    }

    public void enviarMensagem(String emailUsuario, String mensagem) {
        this.mensagens.add(new Mensagem(this.usuarios.get(emailUsuario).getNome(), mensagem));
    }

    public void removerUsuario(String emailUsuario) {
        this.usuarios.remove(emailUsuario);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Mensagens do canal " + this.nome);

        for (Mensagem mensagem : mensagens) {
            result.append(mensagem).append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canal canal = (Canal) o;
        return Objects.equals(nome, canal.nome) &&
                Objects.equals(mensagens, canal.mensagens) &&
                Objects.equals(usuarios, canal.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, mensagens, usuarios);
    }
}
