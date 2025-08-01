import java.util.HashSet;
import java.util.Set;

public class Palavra {
    private String palavraOriginal;
    private Set<Character> letrasReveladas;

    public Palavra(String palavraOriginal) {
        this.palavraOriginal = palavraOriginal.toUpperCase();
        this.letrasReveladas = new HashSet<>();
    }

    public boolean revelarLetra(char letra){
        letra = Character.toUpperCase(letra);
        if (palavraOriginal.contains(String.valueOf(letra))) {
            letrasReveladas.add(letra);
            return true;
        }
        return false;
    }

    public boolean estaCompleta(){
        for (char c : palavraOriginal.toCharArray()){
            if (!letrasReveladas.contains(c)){
                return false;
            }
        }
        return true;
    }

    public String getPalavraFormatada(){
        StringBuilder sb = new StringBuilder();
        for (char c : palavraOriginal.toCharArray()) {
            if (letrasReveladas.contains(c)) {
                sb.append(c).append(' ');
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    public String getPalavraOriginal() {
        return palavraOriginal;
    }
}
