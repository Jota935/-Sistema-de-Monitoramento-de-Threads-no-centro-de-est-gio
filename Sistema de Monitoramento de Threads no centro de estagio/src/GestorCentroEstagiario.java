import java.util.ArrayList;
import java.util.List;

public class GestorCentroEstagiario {
    private  List<Thread> threads = new ArrayList<>();
    private  List<Computador> computadores = new ArrayList<>();

    public void IniciarComputadores(int quantidade){
        for(int i = 1; i <= quantidade; i++){
            Computador c = new Computador(i);
            Thread t = new Thread(c);
            computadores.add(c);
            threads.add(t);
            t.start();
        }
    }

    public void MostrarEstados(){
        for(Thread t : threads){
            System.out.println("Estado do computador " + t.getName() + " : " + t.getState());
        }
    }

    public void LiberarProximoCiclo(){
        System.out.println("Liberando computadores para proximo estado...");
        for(Computador c: computadores){
            synchronized (c){
                c.LiberarProximoCiclo();
            }
        }
    }

    public void EncerrarCiclo(){
        System.out.println("Encerrando a Fabrica...");
        for (Computador c: computadores){
            synchronized (c){
                c.encerrar();
            }
        }
    }

    public List<Thread> getThreads(){
        return threads;
    }
}
