public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorCentroEstagiario gestor = new GestorCentroEstagiario();
        gestor.IniciarComputadores(3);

        long inicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - inicio < 15000){
            Thread.sleep(3000);

            gestor.MostrarEstados();
            gestor.LiberarProximoCiclo();
            System.out.println("...");
        }
        gestor.EncerrarCiclo();

        for (Thread t: gestor.getThreads()){
            t.join();
        }
        gestor.MostrarEstados();
        System.out.println("Centro de estágio da UM encerrado.");
    }
}