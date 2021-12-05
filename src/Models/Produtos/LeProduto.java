package Models.Produtos;

import org.json.simple.JSONArray;

import Database.Database;
import Models.Produtos.Interfaces.ILeProduto;

public class LeProduto implements ILeProduto {

    @Override
    public JSONArray lerEstoque() {
        return Database.leProduto();
    }

}
