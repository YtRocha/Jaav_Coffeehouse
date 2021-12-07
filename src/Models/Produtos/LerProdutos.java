package Models.Produtos;

import java.io.File;

import Database.Database;
import Utils.Txt.LerArquivo;

public class LerProdutos {

    private String database;

    private String filtro;

    public LerProdutos(String database) {
        this.database = database;
    }
    

    public LerProdutos(String database, String filtro) {
        this.database = database;
        this.filtro = filtro;
    }
    

    public String[][] dadosProdutos() {
        return Database.lerTodosProdutos(database);
    }

    public String[][] dadosProdutosFiltrados(){
        return Database.lerProdutosFiltrados(database, filtro);
    }
}
