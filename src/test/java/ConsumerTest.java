import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsumerTest {

    @Test
    void deveNotificarUmConsumer() {
        Fila fila = new Fila("Fila 1");
        Consumer consumer = new Consumer("Consumer 1");
        consumer.verificarFila(fila);
        fila.inserirMensagem("Mensagem 1");
        assertEquals("Consumer 1, mensagem recebida em Fila 1{mensagem:'Mensagem 1'}", consumer.getUltimaMensagem());
    }

    @Test
    void deveNotificarConsumers() {
        Fila fila = new Fila("Fila 1");
        Consumer consumer1= new Consumer("Consumer 1");
        Consumer consumer2 = new Consumer("Consumer 2");
        consumer1.verificarFila(fila);
        consumer2.verificarFila(fila);
        fila.inserirMensagem("Mensagem 1");
        assertEquals("Consumer 1, mensagem recebida em Fila 1{mensagem:'Mensagem 1'}", consumer1.getUltimaMensagem());
        assertEquals("Consumer 2, mensagem recebida em Fila 1{mensagem:'Mensagem 1'}", consumer2.getUltimaMensagem());
    }

    @Test
    void naoDeveNotificarConsumer() {
        Fila fila = new Fila("Fila 1");
        Consumer consumer = new Consumer("Consumer 1");
        fila.inserirMensagem("Mensagem 1");
        assertEquals(null, consumer.getUltimaMensagem());
    }

    @Test
    void deveNotificarConsumer1() {
        Fila fila1 = new Fila("Fila 1");
        Fila fila2 = new Fila("Fila 2");
        Consumer consumer1= new Consumer("Consumer 1");
        Consumer consumer2 = new Consumer("Consumer 2");
        consumer1.verificarFila(fila1);
        consumer2.verificarFila(fila2);
        fila1.inserirMensagem("Mensagem 1");
        assertEquals("Consumer 1, mensagem recebida em Fila 1{mensagem:'Mensagem 1'}", consumer1.getUltimaMensagem());
        assertEquals(null, consumer2.getUltimaMensagem());

    }
}