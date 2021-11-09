package Models.Produtos;

public abstract class Produto {

    private Long id;

    private String nome;

    private Double preco;

    private int quantidade;

    public Produto() {
    }


    public Produto(Long id, String nome, Double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }


    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public abstract void retirarDoEstoque(int quantidade);

    public abstract void colocarNoEstoque(int quantidade);

}
