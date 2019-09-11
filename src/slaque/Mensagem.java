package slaque;

import java.util.Objects;

public class Mensagem {
    private final String nome;
    private final String mensagem;

    public Mensagem(String nome, String mensagem) {
       this.nome = nome;
       this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return nome + " - " + mensagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem1 = (Mensagem) o;
        return Objects.equals(nome, mensagem1.nome) &&
                Objects.equals(mensagem, mensagem1.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, mensagem);
    }
}
