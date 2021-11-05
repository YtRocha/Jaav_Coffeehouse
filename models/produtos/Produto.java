public abstract class Produto {

    private Long id;

    private String nome;

    private float preco;

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

    public Double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public abstract float calcularValorDaCompra();

    public abstract void retirarDoEstoque();

    public abstract void colocarNoEstoque();

}
