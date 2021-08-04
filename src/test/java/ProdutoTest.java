import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveVender(){
        Produto produto1= new Produto("Caneta",100,1.2,10,200);
        Cliente cliente1= new Cliente("Marco","123");
        produto1.vender("26/07/2021", cliente1,37);
        List<String> transacao = Arrays.asList("Venda do produto "+produto1.getNome());

        assertEquals(transacao,produto1.getHistorico());
    }

    @Test
    void deveVenderEstoqueFicaBaixo(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Cliente cliente1= new Cliente("Marco","123");
        produto1.vender("26/07/2021", cliente1,95);

        assertEquals(true, produto1.verificarEstoqueBaixo());
    }

    @Test
    void deveNaoVender(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Cliente cliente1= new Cliente("Marco","123");
        produto1.vender("26/07/2021", cliente1,110);

       assertEquals(true, produto1.verificarEstoqueInsuficiente(110));
    }

    @Test
    void deveComprar(){
        Produto produto1= new Produto("Caneta",100,1.2f,10,200);
        Fornecedor fornecedor1= new Fornecedor("Antonio","456");
        produto1.comprar("26/07/2021", fornecedor1,50, 1.1);

        List<String> transacao = Arrays.asList("Compra do produto "+produto1.getNome());

        assertEquals(transacao, produto1.getHistorico());
    }

    @Test
    void deveNaoComprar(){
        Produto produto1= new Produto("Caneta",130,1.2f,10,200);
        Fornecedor fornecedor1= new Fornecedor("Antonio","456");
        produto1.comprar("26/07/2021", fornecedor1,50, 1.1f);

        assertEquals(true, produto1.verificarEstoqueExcedente(200));
    }

    @Test
    void deveExibirHistoricoCompleto(){
        Produto produto1= new Produto("Caneta",100,1.2,10,200);
        Cliente cliente1= new Cliente("Marco","123");
        produto1.vender("26/07/2021", cliente1,95);
        Fornecedor fornecedor1= new Fornecedor("Antonio","456");
        produto1.comprar("26/07/2021", fornecedor1,50, 1.1);
        produto1.exibirHistorico();

        List<String> transacao = Arrays.asList("Venda do produto "+produto1.getNome(),"Compra do produto "+produto1.getNome());

        assertEquals(transacao, produto1.getHistorico());

    }

}