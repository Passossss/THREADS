public class PrimosDuas {

    public static void main(int[] args) {
        int inicio = 2;
        int fim = 1000;
        int metade = (inicio + fim) / 2;

        Thread thread1 = new Thread(() -> imprimirPrimos(inicio, metade , "T1"));
        Thread thread2 = new Thread(() -> imprimirPrimos(metade + 1, fim, "T2"));

        thread1.setName("T1");
        thread1.start();
        thread2.setName("T2");
        thread2.start();
    }

    private static void imprimirPrimos(int inicio, int fim, String nome){
        for (int i = inicio; i <= fim; i++) {
            if (ehPrimo(i)) {
                System.out.println(i + " " + nome);
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