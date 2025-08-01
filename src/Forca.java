import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

    public class Forca {
        private Palavra palavra;
        private Set<Character> letrasTentadas;
        private int tentativasRestantes;
        private EstadoJogo estado;

        private final String[] bancoDePalavras = {
                "JAVA", "PROGRAMACAO", "DESAFIO", "ORIENTACAO", "OBJETOS"
        };

    public Forca() {
        this.palavra = new Palavra(escolherPalavraAleatoria());
        this.letrasTentadas = new HashSet<>();
        this.tentativasRestantes = 6;
        this.estado = EstadoJogo.EM_ANDAMENTO;
    }

    private String escolherPalavraAleatoria(){
        Random random = new Random();
        return bancoDePalavras[random.nextInt(bancoDePalavras.length)];
    }

    public void jogarRodada(char letra) throws LetraInvalidaException {
        letra = Character.toUpperCase(letra);

        if(!Character.isLetter(letra)){
            throw new LetraInvalidaException("Voce deve digitar apenas letras.");
        }

        if (letrasTentadas.contains(letra)) {
            throw new LetraInvalidaException("Voce ja tentou essa letra. ");
        }

        letrasTentadas.add(letra);

        boolean acertou = palavra.revelarLetra(letra);

        if(!acertou) {
            tentativasRestantes--;
        }

        if (palavra.estaCompleta()) {
            estado = EstadoJogo.VENCEU;
        } else if (tentativasRestantes == 0) {
            estado = EstadoJogo.PERDEU;
        }
    }

    public void exibirEstadoAtual() {
        System.out.println("\nPalavra: " + palavra.getPalavraFormatada());
        System.out.println("Letras tentadas: " + letrasTentadas);
        System.out.println("Tentativas restantes: " + tentativasRestantes);
    }

    public EstadoJogo getEstado() {
        return estado;
    }

    public String getPalavrasSecreta() {
        return palavra.getPalavraOriginal();
    }
}