public class Processo {

    private Thread t1;
    private Thread t2;

    public Processo() {
        t1 = new MinhaThread("T1");
        t2 = new MinhaThread("T2");
    }

    public void iniciarThreads() {
        t1.start();
        t2.start();
    }

    private static class MinhaThread extends Thread {

        private String nome;

        public MinhaThread(String nome) {
            this.nome = nome;
        }

        @Override
        public void run() {
            System.out.println("Olá da thread " + nome);
        }
    }
}