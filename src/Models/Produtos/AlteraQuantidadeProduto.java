package Models.Produtos;

import Database.Database;
import Models.Produtos.Interfaces.IAlteraQuantidadeProduto;

public class AlteraQuantidadeProduto implements IAlteraQuantidadeProduto{
    
    private String codigo;

    private int quantidade;

    private boolean somar;

    public AlteraQuantidadeProduto(String codigo, int quantidade, boolean somar) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.somar = somar;
    }

    @Override
    public boolean alterar() {
        return Database.alteraQuantidadeProduto(codigo, quantidade, somar);
    }

}
