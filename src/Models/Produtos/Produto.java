package Models.Produtos;

public abstract class Produto {

    private Long id;

    private String nome;

    private Double preco;

    private int quantidade;
    

    /* ---- Construtores ---- */

    public Produto() {
    }

    public Produto(Long id, String nome, Double preco, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    /* ---- Metodos ---- */

    public void retirarDoEstoque(int quantidade){
        if(this.getQuantidade() > 0){
            if((this.getQuantidade()-quantidade) < 0){

            }
            else
                this.setQuantidade(this.getQuantidade()-quantidade);
        }
    }

    public void colocarNoEstoque(int quantidade){
        this.setQuantidade(this.getQuantidade()+quantidade);
    }


}
