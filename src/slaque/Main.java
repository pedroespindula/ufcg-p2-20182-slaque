package slaque;

import java.util.Scanner;

public class Main {

    private final Slaque slaque;
    private final Scanner input;

    public Main() {
        this.slaque = new Slaque();
        this.input = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();

        String promptEntrada = "Digite a opção desejada: ";

        System.out.println(main.getTitulo());

        int opcao = 0;
        while (opcao != 7) {
            System.out.println(main.getMenu());
            opcao = Integer.parseInt(main.lerEntrada(promptEntrada));
            System.out.println();

            switch (opcao) {
                case 1: main.cadastrarUsuario(); break;
                case 2: main.cadastrarCanal(); break;
                case 3: main.entrarEmCanal(); break;
                case 4: main.mandarMensagem(); break;
                case 5: main.sairCanal(); break;
                case 6: main.imprimirMensagens(); break;
                case 7: System.out.println("Até mais"); break;
                default:
                    System.out.println("Entrada inválida");
            }
            System.out.println();
        }
    }

    private String getMenu() {
        return "- Opções:" + System.lineSeparator() +
                "[1] Cadastrar usuario" + System.lineSeparator() +
                "[2] Cadastrar canal" + System.lineSeparator() +
                "[3] Cadastrar usuario em canal" + System.lineSeparator() +
                "[4] Mandar mensagem" + System.lineSeparator() +
                "[5] Remover usuario de canal" + System.lineSeparator() +
                "[6] Imprimir mensagens de canal" + System.lineSeparator() +
                "[7] Sair" + System.lineSeparator();
    }

    private String getTitulo() {
        return "   _____ _               ____  _    _ ______ \n" +
                "  / ____| |        /\\   / __ \\| |  | |  ____|\n" +
                " | (___ | |       /  \\ | |  | | |  | | |__   \n" +
                "  \\___ \\| |      / /\\ \\| |  | | |  | |  __|  \n" +
                "  ____) | |____ / ____ \\ |__| | |__| | |____ \n" +
                " |_____/|______/_/    \\_\\___\\_\\\\____/|______|\n" +
                "                                             ";
    }

    public void cadastrarUsuario() {
        System.out.println("== Cadastrar usuario: ==");
        String nomeUsuario = lerEntrada("Digite o nome do usuario: ");
        String emailUsuario = lerEntrada("Digite o email do usuario: ");

        this.slaque.cadastrarUsuario(nomeUsuario, emailUsuario);
    }

    public void cadastrarCanal() {
        System.out.println("== Cadastrar canal: ==");
        String nomeCanal = lerEntrada("Digite o nome do canal: ");

        this.slaque.cadastrarCanal(nomeCanal);
    }

    public void entrarEmCanal() {
        System.out.println("== Entrar em canal: ==");
        String nomeCanal = lerEntrada("Digite o nome do canal: ");
        String emailUsuario = lerEntrada("Digite o email do usuario: ");

        this.slaque.entrarEmCanal(nomeCanal, emailUsuario);
    }

    public void mandarMensagem() {
        System.out.println("== Mandar mensagem: ==");
        String nomeCanal = lerEntrada("Digite o nome do canal: ");
        String emailUsuario = lerEntrada("Digite o email do usuario: ");
        String mensagem = lerEntrada("Digite a mensagem: ");

        this.slaque.enviarMensagem(nomeCanal, emailUsuario, mensagem);
    }

    public void sairCanal() {
        System.out.println("== Sair do canal: ==");
        String nomeCanal = lerEntrada("Digite o nome do canal: ");
        String emailUsuario = lerEntrada("Digite o email do usuario: ");

        this.slaque.sairDoCanal(nomeCanal, emailUsuario);
    }

    public void imprimirMensagens() {
        System.out.println("== Mensagens do canal: ==");
        String nomeCanal = lerEntrada("Digite o nome do canal: ");

        System.out.println(this.slaque.imprimeCanal(nomeCanal));
    }

    public String lerEntrada(String mensagem) {
        System.out.print(mensagem);
        String nomeUsuario = input.nextLine();
        return nomeUsuario;
    }

}
