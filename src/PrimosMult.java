import java.util.Scanner;

public class PrimosMult {
    //Múltiplas threads para subintervalos
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o intervalo de início: ");
        int inicio = scanner.nextInt();

        System.out.println("Digite o intervalo de fim: ");
        int fim = scanner.nextInt();

        System.out.println("Digite quantas threads: ");
        int qnt_threads = scanner.nextInt();

        int intervalo = (fim - inicio + 1) / qnt_threads;

        class PrimeThread extends Thread {
            private int threadId;
            private int start;
            private int end;

            public PrimeThread(int threadId, int start, int end) {
                this.threadId = threadId;
                this.start = start;
                this.end = end;
            }

            @Override
            public void run() {
                for (int i = start; i <= end; i++) {
                    if (ehPrimo(i)) {
                        System.out.println(i + " T" + threadId);
                    }
                }
            }
        }

        Thread[] threads = new Thread[qnt_threads];

        for (int i = 0; i < qnt_threads; i++) {
            int start = inicio + i * intervalo;
            int end = (i == qnt_threads - 1) ? fim : (start + intervalo - 1);
            threads[i] = new PrimeThread(i + 1, start, end);
            threads[i].start();
        }

        for (int i = 0; i < qnt_threads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}