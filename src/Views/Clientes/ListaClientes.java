package Views.Clientes;

import javax.swing.*;

import Models.Clientes.LerClientes;

public class ListaClientes extends AbaClientes {
    String[][] clientes = new LerClientes().dadosClientes();

    public ListaClientes() {
        inicializar();
    }

    public void inicializar() {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        String[] colunas = { "ID", "Nome", "CPF" };

        JTable tabela = new JTable(clientes, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
    }
}