import java.util.Scanner;

public class PrimosMult {
    //Múltiplas threads para subintervalos
    public static void main(String[] args) {
        int inicio = 2;
        int fim = 1000000;
        System.out.println("Digite quantas threads: ");
        int qnt_threads = new Scanner(System.in).nextInt();

        System.out.println("Digite o intervalo: ");
        int intervalo = new Scanner(System.in).nextInt();

        class th{

            String nome;
            public th(String nome){
                this.nome = nome;
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = inicio; i <= fim; i += intervalo) {
                        int fimSubintervalo = Math.min(i + intervalo - 1, fim);
                        int finalI = i;
                        imprimirPrimos(finalI, fimSubintervalo, nome);

                    }
                }
            });
        }

        for (int i = 0; i<qnt_threads; i++){
            th t = new th(String.format("%d", i+1));
            t.thread.start();
        }
    }

    private static void imprimirPrimos(int inicio, int fim, String nome) {
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.println(i + String.format(" - T%s", nome));
            }
        }
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