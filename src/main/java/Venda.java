public class Venda extends Transacao {

    private Cliente cliente;

    public Venda(String dataVenda , Cliente cliente, Produto produto, int qtdeVendida) {
        super(dataVenda,produto,qtdeVendida);
        this.cliente =cliente;
    }

    public boolean vender(Produto produto, int qtdeVendida){
        if(produto.verificarEstoqueInsuficiente(qtdeVendida)){
            System.out.println("Estoque Insuficiente - Venda dessa quantidade não possível ");
            return false;
        }else{
            produto.debitarEstoque(qtdeVendida);
            System.out.println("Valor da Venda = " + produto.calcularValorVenda(qtdeVendida));
            if(produto.verificarEstoqueBaixo()){
                System.out.println("Estoque Baixo");
            }
            return true;
        }
    }


}
