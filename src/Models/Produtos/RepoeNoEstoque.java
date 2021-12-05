package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.IRepoeNoEstoque;

public class RepoeNoEstoque implements IRepoeNoEstoque {

    private String codigo;

    private int quantidade;

    public RepoeNoEstoque(String codigo, int quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    @Override
    public boolean repor() {
        return Database.repoeNoEstoque(codigo, quantidade);
    }

}
