import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompraTest {

    @Test
    void deveComprar(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Fornecedor fornecedor1= new Fornecedor("Antonio","456");
        Compra compra1 = new Compra("26/07/2021",produto1,fornecedor1,50,1.1f);

        assertEquals(true, compra1.comprar(produto1,50));
    }

    @Test
    void deveNaoComprar(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Fornecedor fornecedor1= new Fornecedor("Antonio","456");
        Compra compra1 = new Compra("26/07/2021",produto1,fornecedor1,120,1.1f);

        assertEquals(false, compra1.comprar(produto1,120));
    }

}