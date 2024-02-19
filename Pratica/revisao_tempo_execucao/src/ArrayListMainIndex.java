import fonte.Pessoa;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListMainIndex {
    public static void main(String[] args) {

        //tamanho de pessoas a serem preenchidas no vetor
        final int TAMANHO_P = 10_000_000;
        //quantidade de números que seram buscados
        final int TAMANHO_N = 20_000;
        final double NANO_TO_MS = 1_000_000d;
        final double MS_TO_SEC = 1_000d;
        Random r = new Random(42);
        List<Pessoa> pessoas = new ArrayList<>();

        long ini = System.nanoTime();

        try {
            for (int i = 0; i < TAMANHO_P; i++) {
                    pessoas.add(new Pessoa(i + 1, "Caram"));
            }
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < TAMANHO_N; i++) {
                    boolean pessoaEncontrada = pessoas.indexOf(new Pessoa(r.nextInt(TAMANHO_P), "Ts")) != -1;
            }
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }
    
        long fim = System.nanoTime();

        double tempoMs = (fim-ini)/NANO_TO_MS;
        double tempoSeg = tempoMs/MS_TO_SEC;

        System.out.println("Finalizado em "+ String.format("%.2f",tempoMs)+" ms ("
                +  String.format("%.4f",tempoSeg)+" segundos).");

    }
}