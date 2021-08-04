public class Compra extends Transacao{

    private double precoUnit;
    private Produto produto;
    private Fornecedor fornecedor;

    public Compra(String dataCompra ,Produto produto, Fornecedor fornecedor, int qtdeCompra, double precoUnit) {
        super(dataCompra,produto,qtdeCompra);
        this.precoUnit = precoUnit;
        this.fornecedor = fornecedor;
    }

    public boolean comprar(Produto produto, int qtdeCompra){
        if(produto.verificarEstoqueExcedente(qtdeCompra)){
            System.out.println("Estoque Excedente - Não Compre");
            return false;
        }else{
            produto.creditarEstoque(qtdeCompra);
            return true;
        }
    }

}
