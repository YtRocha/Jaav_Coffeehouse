package Models.Vendas;

import java.io.File;

import Database.Database;
import Models.Vendas.Interfaces.ILerVendas;
import Utils.Txt.LerArquivo;

public class LerVendas implements ILerVendas {
    LerArquivo vendas = new LerArquivo("src" + File.separator + "Database" + File.separator + "vendas.txt");
    LerArquivo vendas_identificadas = new LerArquivo(
            "src" + File.separator + "Database" + File.separator + "vendas_identificadas.txt");

    public String[][] dadosVendas() {
        return Database.dadosVendas();
    }

    public String[][] dadosVendasIdentificadas(String filtrar_cpf) {
        return Database.dadosVendasIdentificadas(filtrar_cpf);
    }
}
