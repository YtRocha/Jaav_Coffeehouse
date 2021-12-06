package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.ICadastraProduto;

public class CadastraAperitivo implements ICadastraProduto {
    private Aperitivo aperitivo = new Aperitivo();

    public CadastraAperitivo(String codigo, String nome, Double preco, int quantidade, String categorias,
            String tamanho) {
        aperitivo.setCodigo(codigo);
        aperitivo.setNome(nome);
        aperitivo.setPreco(preco);
        aperitivo.setQuantidade(quantidade);
        aperitivo.setCategorias(categorias);
        aperitivo.setTamanho(tamanho);
    }

    @Override
    public boolean cadastrar() {
        return Database.cadastraAperitivo(this.aperitivo);
    }



}
