public class PrimosMult {
    //Múltiplas threads para subintervalos
    public static void main(String[] args) {
        int inicio = 5;
        int fim = 10000000;
        int intervalo = 2500;

        for (int i = inicio; i <= fim; i += intervalo) {
            int fimSubintervalo = Math.min(i + intervalo - 1, fim);
            int finalI = i;
            Thread thread = new Thread(() -> imprimirPrimos(finalI, fimSubintervalo));
            thread.start();
        }
    }

    private static void imprimirPrimos(int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.println(i);
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