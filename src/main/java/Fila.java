import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Fila extends Observable {

    private String nomeFila;
    private List<String> mensagens = new ArrayList<>();

    public Fila(String nomeFila) {
        this.nomeFila = nomeFila;
    }

    public String getNomeFila() {
        return nomeFila;
    }

    public void setNomeFila(String nomeFila) {
        this.nomeFila = nomeFila;
    }

    public void inserirMensagem(String mensagem) {
        this.mensagens.add(mensagem);
        setChanged();
        notifyObservers();
    }

    public String getUltimaMensagem() {
        return mensagens.get(mensagens.size()-1);
    }

    @Override
    public String toString(){
        return this.getNomeFila() + "{mensagem:\'" +this.getUltimaMensagem()+"\'}";
    }

}
