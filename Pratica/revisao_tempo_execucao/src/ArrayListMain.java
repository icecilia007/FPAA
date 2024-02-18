import fonte.Pessoa;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayListMain {
    public static void main(String[] args) {

        //tamanho de pessoas a serem preenchidas no vetor
        final int TAMANHO_P = 100;
        //quantidade de números que seram buscados
        final int TAMANHO_N = 20;
        final double NANO_TO_MS = 1_000_000d;
        final double MS_TO_SEC = 1_000d;
        Random r = new Random(42);
        int[] valores = new int[TAMANHO_N];
        char c;

        List<Pessoa> pessoas = new ArrayList<>();
        List<Integer> idsPessoas = new ArrayList<>();
        int somaIds = 0;

        long ini = System.nanoTime();

        for (int i = 0; i < TAMANHO_P; i++) {
            c=(char)(r.nextInt(26)+'a');

            try {
                pessoas.add(new Pessoa(i+1,genereteRandomName(c)));
                idsPessoas.add(i+1);
            } catch (InvalidAttributeValueException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < TAMANHO_N; i++) {
            valores[i] = r.nextInt(TAMANHO_P) + 1;
            if (idsPessoas.contains(valores[i])) somaIds++;
        }
        System.out.println("Soma dos IDs: " + somaIds);

        long fim = System.nanoTime();

        double tempoMs = (fim-ini)/NANO_TO_MS;
        double tempoSeg = tempoMs/MS_TO_SEC;

        System.out.println("Finalizado em "+ String.format("%.2f",tempoMs)+" ms ("
                +  String.format("%.4f",tempoSeg)+" segundos).");

    }
    private static String genereteRandomName(char c){
        String name = "P"+c;
        return name;
    }
}