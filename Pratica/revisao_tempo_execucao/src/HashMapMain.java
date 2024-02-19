import fonte.Pessoa;
import javax.management.InvalidAttributeValueException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class HashMapMain {
    public static void main(String[] args) {

        final int TAMANHO_P = 10_000_000;
        final int TAMANHO_N = 20_000;
        final double NANO_TO_MS = 1_000_000d;
        final double MS_TO_SEC = 1_000d;
        Random r = new Random(42);
//        int[] valores = new int[TAMANHO_N];
        long ini = System.nanoTime();

        Map<Integer, Pessoa> mapaPessoas = new HashMap<>();
        try {
            for (int i = 0; i < TAMANHO_P; i++) {
                    mapaPessoas.put(i+1, new Pessoa(i+1, "Caram"));
            }
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < TAMANHO_N; i++) {
//            valores[i] = r.nextInt(TAMANHO_P);
            if (mapaPessoas.containsKey(r.nextInt(TAMANHO_P)));
        }

        long fim = System.nanoTime();

        double tempoMs = (fim - ini) / NANO_TO_MS;
        double tempoSeg = tempoMs / MS_TO_SEC;

        System.out.println("Finalizado em " + String.format("%.2f", tempoMs) + " ms ("
                + String.format("%.4f", tempoSeg) + " segundos).");

    }

}
