package Models.Clientes;

import java.util.ArrayList;

import Models.Clientes.Interfaces.ILerClientes;
import Utils.Txt.LerArquivo;

public class LerClientesExcluidos implements ILerClientes {
    LerArquivo clientes = new LerArquivo("src/Database/clientes_excluidos.txt");

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
