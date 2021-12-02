package Models.Produtos;

import Models.Produtos.Interfaces.IProduto;

public abstract class Produto implements IProduto {

    private Long id;

    private String nome;

    private Double preco;

    private String quantidade;

    private String categoria;
    

    /* ---- Construtores ---- */

    public Produto() {
    }

    public Produto(Long id, String nome, Double preco, String quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    /* ---- Getters e Setters ---- */

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

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria(){
        return this.categoria;
    }

    public void setCategoria(String categoria){
        this.categoria = categoria;
    }

    /* ---- Metodos ---- */
    // TODO: Implementar corretamente os metodos abaixo
    public boolean retirarDoEstoque(int quantidade) {
        
        return false;
    }

    public boolean colocarNoEstoque(int quantidade) {
        
        return true;
    }

}
