import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int intervaloInicio = 2;
        int intervaloFim = 10;
        //ex1 2,10 usar

        List<Integer> primosEncontrados = new ArrayList<>();

       // int numeroSubintervalos = 4;
       // int tamanhoSubintervalo = (intervaloFim - intervaloInicio) / numeroSubintervalos;

        List<MinhaThread> threadsCriadas = new ArrayList<>();
        //ex D)
        /*for (int i = 0; i < numeroSubintervalos; i++) {
            int inicioSubintervalo = intervaloInicio + i * tamanhoSubintervalo;
            int fimSubintervalo = Math.min(inicioSubintervalo + tamanhoSubintervalo - 1, intervaloFim);
            MinhaThread thread = new MinhaThread(inicioSubintervalo, fimSubintervalo, primosEncontrados);
            thread.start();
            threadsCriadas.add(thread);
        }*/

        // para exercicio C)
        int metade = (intervaloFim - intervaloInicio) / 2;

        MinhaThread thread1 = new MinhaThread(intervaloInicio, metade, primosEncontrados);
        thread1.start();

        MinhaThread thread2 = new MinhaThread(metade + 1, intervaloFim, primosEncontrados);
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Primos encontrados no intervalo [" + intervaloInicio + "," + intervaloFim + "]:");
        for (Integer primo : primosEncontrados) {
            System.out.print(primo + " ");
        }
    }
}