import java.util.List;

class MinhaThread extends Thread {

    private final int inicio;
    private final int fim;
    private final List<Integer> primosEncontrados;

    public MinhaThread(int inicio, int fim, List<Integer> primosEncontrados) {
        this.inicio = inicio;
        this.fim = fim;
        this.primosEncontrados = primosEncontrados;
    }

    @Override
    public void run() {
        for (int numero = inicio; numero <= fim; numero++) {
            if (ehPrimo(numero)) {
                primosEncontrados.add(numero);
            }
        }
    }

    private boolean ehPrimo(int numero) {
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