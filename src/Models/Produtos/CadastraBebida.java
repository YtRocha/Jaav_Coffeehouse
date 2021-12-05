package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.ICadastraProduto;

public class CadastraBebida implements ICadastraProduto{
    private Bebida bebida =  new Bebida();



    public CadastraBebida(String codigo, String nome, Double preco, int quantidade,String categorias) {
        bebida.setCodigo(codigo);
        bebida.setNome(nome);
        bebida.setPreco(preco);
        bebida.setQuantidade(quantidade);
        bebida.setCategorias(categorias);
    }

    @Override
    public boolean cadastrar() {
        return Database.cadastraBebida(this.bebida);
    }

    @Override
    public String geraId() {
        // TODO Auto-generated method stub
        return null;
    }

}
