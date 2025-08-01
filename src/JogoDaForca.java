import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jogando = true;

        System.out.println("=== JOGO DA FORCA ===");

        while (jogando) {
            System.out.println("\n1 - Jogar");
            System.out.println("2 - Sair");
            System.out.print("Escolha: ");
            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    jogar(scanner);
                    break;
                case "2":
                    jogando = false;
                    System.out.println("Saindo do jogo. Até mais!");
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        }

        scanner.close();
    }

    private static void jogar(Scanner scanner)  {
        Forca forca = new Forca();

        while (forca.getEstado() == EstadoJogo.EM_ANDAMENTO) {
            forca.exibirEstadoAtual();

            System.out.print("Digite uma letra: ");
            String entrada = scanner.nextLine();

            if (entrada.length() != 1) {
                System.out.println("Digite apenas uma letra.");
                continue;
            }

            char letra = entrada.charAt(0);

            try {
                forca.jogarRodada(letra);
            } catch (LetraInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        if (forca.getEstado() == EstadoJogo.VENCEU) {
            System.out.println("\n Parabéns! Você acertou a Palavra: " + forca.getPalavrasSecreta());
        } else {
            System.out.println("\n Você perdeu! A palavra era: " + forca.getPalavrasSecreta());
        }
    }
}1
