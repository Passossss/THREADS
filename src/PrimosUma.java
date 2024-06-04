public class PrimosUma {
    //imprimir
    public static void main(String[] args) {
        int inicio = 2;
        int fim = 10000000;

        Thread threadPrimos = new Thread(() -> {
            for (int i = inicio; i <= fim; i++) {
                if (ehPrimo(i)) {
                    System.out.println(i);
                }
            }
        });

        threadPrimos.start();
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