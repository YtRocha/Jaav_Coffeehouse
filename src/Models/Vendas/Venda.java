package Models.Vendas;

public class Venda {
    private String produto;
    private String cpf;
    private double valor;
    private int quantidade;

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getProduto() {
        return this.produto;
    }

    public Venda() {
    }

    public Venda(String produto, String cpf, double valor, int quantidade) {
        this.produto = produto;
        this.cpf = cpf;
        this.valor = valor;
        this.quantidade = quantidade;
    }
}
