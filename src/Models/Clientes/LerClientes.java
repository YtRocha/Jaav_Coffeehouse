package Models.Clientes;

import java.util.ArrayList;

import Utils.Txt.LerArquivo;

public class LerClientes {
    LerArquivo clientes = new LerArquivo("src/Database/clientes.txt");

    public String[][] dadosClientes() {
        String[] clientes = this.clientes.lerArquivo().split("\n");

        ArrayList<String[]> dados = new ArrayList<String[]>();

        String[][] dados_array = new String[dados.size()][];

        for (String cliente : clientes) {
            String[] dados_cliente = cliente.split("\\|");
            dados.add(dados_cliente);
        }
        
        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

}
