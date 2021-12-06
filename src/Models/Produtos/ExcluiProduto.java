package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.IExcluiProduto;

public class ExcluiProduto implements IExcluiProduto {

    private String codigo;

    private String database;

    public ExcluiProduto(String codigo, String database) {
        this.codigo = codigo;
        this.database = database;
    }

    @Override
    public boolean excluir() {
        return Database.excluiProduto(this.codigo, this.database);
    }

}
