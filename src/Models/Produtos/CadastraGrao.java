package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.ICadastraProduto;

public class CadastraGrao implements ICadastraProduto {
    private Grao grao = new Grao();

    public CadastraGrao(String codigo, String nome, Double preco, int quantidade, String categorias, String marca,
            Boolean gourmet, String torra) {
        grao.setCodigo(codigo);
        grao.setNome(nome);
        grao.setPreco(preco);
        grao.setQuantidade(quantidade);
        grao.setCategorias(categorias);
        grao.setMarca(marca);
        grao.setGourmet(gourmet);
        grao.setTorra(torra);
    }

    @Override
    public boolean cadastrar() {
        return Database.cadastraGrao(this.grao);
    }

    @Override
    public String geraId() {
        // TODO Auto-generated method stub
        return null;
    }

}
