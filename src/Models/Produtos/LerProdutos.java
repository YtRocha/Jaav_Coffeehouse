package Models.Produtos;

import java.io.File;

import Database.Database;
import Utils.Txt.LerArquivo;

public class LerProdutos {
    LerArquivo vendas = new LerArquivo("src" + File.separator + "Database" + File.separator + "vendas.txt");

    public String[][] dadosProdutos() {
        return Database.lerTodosProdutos();
    }
}
