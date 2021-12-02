package Models.Produtos.Interfaces;

public interface IProduto {

    public boolean retirarDoEstoque(int quantidade);

    public boolean colocarNoEstoque(int quantidade);

}
