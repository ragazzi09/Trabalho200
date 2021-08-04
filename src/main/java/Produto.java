import java.util.ArrayList;
import java.util.List;


//Amanda Lopes Machado, 201935002
//João Pedro Carvalho Ragazzi, 201935011

public class Produto {

    private String nome;
    private int qtdeEstoque;
    private double precoUnit;
    private int estoqueMinimo;
    private int estoqueMaximo;
    private List<String> historico = new ArrayList<String>();

    public Produto(String nome,int qtdeEstoque,double precoUnit, int estoqueMinimo, int estoqueMaximo) {
        this.nome = nome;
        this.qtdeEstoque = qtdeEstoque;
        this.precoUnit= precoUnit;
        this.estoqueMinimo= estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    public void registrarHistorico(String transacao){
            historico.add(transacao);
    }

    public void exibirHistorico(){
        for (String transacao : historico) {
            System.out.println(transacao);
        }

    }

    public void debitarEstoque(int qtde){
        this.qtdeEstoque = this.qtdeEstoque - qtde;
    }

    public void creditarEstoque(int qtde){
        this.qtdeEstoque = this.qtdeEstoque + qtde;
    }

    public boolean verificarEstoqueBaixo(){
        if(qtdeEstoque < estoqueMinimo){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarEstoqueInsuficiente(int qtde){
        if(qtdeEstoque < qtde){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarEstoqueExcedente(int qtde){
        if(qtdeEstoque + qtde > estoqueMaximo){
            return true;
        }else{
            return false;
        }
    }

    public double calcularValorVenda(int qtde){
        return qtde * precoUnit;
    }

    public void vender(String dataVenda, Cliente cliente, int qtdeVendida){
        Venda venda= new Venda(dataVenda,cliente,this,qtdeVendida);
        if(venda.vender(this,qtdeVendida)){
            this.registrarHistorico("Venda do produto "+this.nome);
        }
    }

    public void comprar(String dataCompra, Fornecedor fornecedor, int qtdeCompra, double precoUnit){
        Compra compra= new Compra(dataCompra,this,fornecedor,qtdeCompra, precoUnit);
        if(compra.comprar(this,qtdeCompra)){
            this.registrarHistorico("Compra do produto "+this.nome);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getHistorico() {
        return historico;
    }
}
