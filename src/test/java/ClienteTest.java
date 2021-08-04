import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveRetornarCliente(){
        Cliente cliente= new Cliente("Amanda","123");
        assertEquals("Amanda", cliente.getNome());
    }

}