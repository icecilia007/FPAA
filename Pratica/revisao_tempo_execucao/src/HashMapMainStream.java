import fonte.Pessoa;
import javax.management.InvalidAttributeValueException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class HashMapMainStream {
    public static void main(String[] args) {

        final int TAMANHO_P = 2_500_000;
        final int TAMANHO_N = 40_000;
        final double NANO_TO_MS = 1_000_000d;
        final double MS_TO_SEC = 1_000d;
        Random r = new Random(42);
        int[] valores = new int[TAMANHO_N];
        long ini = System.nanoTime();

        Map<Integer, Pessoa> mapaPessoas = new HashMap<>();
        for (int i = 0; i < TAMANHO_P; i++) {
            try {
                mapaPessoas.put(i+1, new Pessoa(i+1, "Pe"));
            } catch (InvalidAttributeValueException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < TAMANHO_N; i++) {
            valores[i] = r.nextInt(TAMANHO_P) + 1;
        }

        Arrays.stream(valores)
                .forEach(id -> mapaPessoas.containsKey(id));

        long fim = System.nanoTime();

        double tempoMs = (fim - ini) / NANO_TO_MS;
        double tempoSeg = tempoMs / MS_TO_SEC;

        System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                + String.format("%.4f", tempoSeg) + " segundos).");

    }

}
