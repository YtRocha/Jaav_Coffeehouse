package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.IExcluiProduto;

public class ExcluiProduto implements IExcluiProduto {

    private String codigo;

    public ExcluiProduto(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean excluir() {
        return Database.excluiProduto(this.codigo);
    }

}
