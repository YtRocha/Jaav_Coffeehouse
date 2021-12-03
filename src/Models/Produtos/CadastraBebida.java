package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.ICadastraProduto;

public class CadastraBebida implements ICadastraProduto{
    private Bebida bebida =  new Bebida();



    public CadastraBebida(String nome, Double preco, int quantidade,String categoria) {
        bebida.setNome(nome);
        bebida.setPreco(preco);
        bebida.setQuantidade(quantidade);
        bebida.setCategoria(categoria);
    }

    @Override
    public boolean cadastrar() {
        return Database.CadastraBebida(this.bebida);
    }

    @Override
    public String geraId() {
        // TODO Auto-generated method stub
        return null;
    }

}
