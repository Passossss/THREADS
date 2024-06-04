import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int intervaloInicio = 2;
        int intervaloFim = 10;
        //ex 1 - 2;10


        List<Integer> primosEncontrados = new ArrayList<>();

        int numeroThreads = 4;
        int tamanhoSubintervalo = (intervaloFim - intervaloInicio) / numeroThreads;

        List<MinhaThread> threadsCriadas = new ArrayList<>(); // Lista para armazenar os objetos MinhaThread

        for (int i = 0; i < numeroThreads; i++) {
            int inicioSubintervalo = intervaloInicio + i * tamanhoSubintervalo;
            int fimSubintervalo = Math.min(inicioSubintervalo + tamanhoSubintervalo - 1, intervaloFim);
            MinhaThread thread = new MinhaThread(inicioSubintervalo, fimSubintervalo, primosEncontrados);
            thread.start();
            threadsCriadas.add(thread);
        }

        for (MinhaThread thread : threadsCriadas) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Primos encontrados no intervalo [" + intervaloInicio + "," + intervaloFim + "]:");
        for (Integer primo : primosEncontrados) {
            System.out.print(primo + " ");
        }
    }
}
