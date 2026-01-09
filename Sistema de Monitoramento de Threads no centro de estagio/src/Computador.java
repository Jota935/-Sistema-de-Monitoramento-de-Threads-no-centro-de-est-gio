public class Computador implements Runnable{
    private final int id;
    private boolean ativo = true;

    public Computador(int id) {
        this.id = id;
    }

    public synchronized void encerrar(){
        ativo = false;
        notifyAll();
    }

    public synchronized void LiberarProximoCiclo() {
        notify();
    }

    @Override
    public void run() {
        try{
            while (ativo){
                System.out.println("Computador " + id + "  está operando...");
                Thread.sleep(2000);

                synchronized (this){
                    if (!ativo) break;
                    System.out.println("Computador " + id + " aguardando liberação para o próximo ciclo.");

                    wait();
                }
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Computador " + id + " encerrado");
    }
}