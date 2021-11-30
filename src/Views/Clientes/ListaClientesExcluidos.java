package Views.Clientes;

import javax.swing.*;

import Models.Clientes.LerClientesExcluidos;

public class ListaClientesExcluidos extends AbaClientes {
    String[][] clientes_excluidos = new LerClientesExcluidos().dadosClientes();

    public ListaClientesExcluidos() {
        inicializar();
    }

    public void inicializar(){
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        String [] colunas = { "ID", "Nome", "CPF", "Data de exlusão" };

        JTable tabela = new JTable(clientes_excluidos, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        
        painel.add(scroll);
    }
}