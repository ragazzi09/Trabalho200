import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendaTest {

    @Test
    void deveVender(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Cliente cliente1= new Cliente("Antonio","456");
        Venda venda1 = new Venda("26/07/2021", cliente1,produto1,30);

        assertEquals(true, venda1.vender(produto1,30));
    }

    @Test
    void deveNaoVender(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Cliente cliente1= new Cliente("Antonio","456");
        Venda venda1 = new Venda("26/07/2021", cliente1,produto1,150);

        assertEquals(false, venda1.vender(produto1,150));
    }

}