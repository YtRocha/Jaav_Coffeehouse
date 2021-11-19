package Models.Vendas;

import Utils.Txt.LerArquivo;

public class LerVendas {
    LerArquivo vendas = new LerArquivo("src\\Database\\vendas.txt");
    LerArquivo vendas_identificadas = new LerArquivo("src\\Database\\vendas_identificadas.txt");

    public Object[][] dadosVendas() {
        String[] vendas = this.vendas.lerArquivo().split("\n");
        Object[][] vendas_array = new Object[vendas.length][3];

        for (int i = 0; i < vendas.length; i++) {
            String[] vendas_linha = vendas[i].split("\\|");
            vendas_array[i][0] = vendas_linha[0];
            vendas_array[i][1] = vendas_linha[1];
            vendas_array[i][2] = vendas_linha[2];
        }

        return vendas_array;
    }

    public Object[][] dadosVendasIdentificadas() {
        String[] vendas_identificadas = this.vendas_identificadas.lerArquivo().split("\n");
        Object[][] vendas_identificadas_array = new Object[vendas_identificadas.length][4];

        for (int i = 0; i < vendas_identificadas.length; i++) {
            String[] vendas_identificadas_linha = vendas_identificadas[i].split("\\|");
            vendas_identificadas_array[i][0] = vendas_identificadas_linha[0];
            vendas_identificadas_array[i][1] = vendas_identificadas_linha[1];
            vendas_identificadas_array[i][2] = vendas_identificadas_linha[2];
            vendas_identificadas_array[i][3] = vendas_identificadas_linha[3];
        }

        return vendas_identificadas_array;
    }
}
