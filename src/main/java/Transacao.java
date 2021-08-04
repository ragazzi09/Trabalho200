public class Transacao {

    protected String dataTransacao;
    protected int qtde;
    protected Produto produto;

    public Transacao(String dataTransacao, Produto produto, int qtde) {
        this.dataTransacao = dataTransacao;
        this.produto = produto;
        this.qtde= qtde;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }
}
