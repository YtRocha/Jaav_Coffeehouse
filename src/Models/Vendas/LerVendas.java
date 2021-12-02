package Models.Vendas;

import java.util.ArrayList;

import Models.Vendas.Interfaces.ILerVendas;
import Utils.Txt.LerArquivo;

public class LerVendas implements ILerVendas {
    LerArquivo vendas = new LerArquivo("src/Database/vendas.txt");
    LerArquivo vendas_identificadas = new LerArquivo("src/Database/vendas_identificadas.txt");

    public String[][] dadosVendas() {
        String[] vendas = this.vendas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];

        for (String venda : vendas) {
            String[] dados_venda = venda.split("\\|");
            dados.add(dados_venda);

            System.out.println(venda);
        }
        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    // TODO: Melhorar a lógica do filtro
    public String[][] dadosVendasIdentificadas(String filtrar_cpf) {
        String[] vendas = this.vendas_identificadas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];

        for (String venda : vendas) {
            String[] dados_venda = venda.split("\\|");

            if (filtrar_cpf != null) {
                if (dados_venda[3].trim().equals(filtrar_cpf)) {
                    dados.add(dados_venda);
                }
            } else {
                dados.add(dados_venda);
            }
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }
}
