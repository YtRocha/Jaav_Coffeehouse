package Models.Produtos;

public abstract class Produto {

    private String id;

    private String codigo;

    private String nome;

    private Double preco;

    private int quantidade;

    private String categorias;

    /* ---- Construtores ---- */

    public Produto() {
    }

    public Produto(String id, String codigo, String nome, Double preco, int quantidade, String categorias) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categorias = categorias;
    }

    /* ---- Getters e Setters ---- */

    public String getId() {
        return this.id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getCategorias() {
        return this.categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }

}
