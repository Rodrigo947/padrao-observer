import java.util.Observable;
import java.util.Observer;

public class Consumer implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Consumer(String nome) {
        this.nome = nome;
    }

    public String getUltimaMensagem() {
        return this.ultimaNotificacao;
    }

    public void verificarFila(Fila fila) {
        fila.addObserver(this);
    }

    public void update(Observable fila, Object arg1) {
        this.ultimaNotificacao = this.nome + ", mensagem recebida em " + fila.toString();
    }
}
