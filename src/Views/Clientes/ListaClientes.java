package Views.Clientes;

import javax.swing.*;

import Models.Clientes.LerClientes;

public class ListaClientes extends AbaClientes {
    String[][] clientes = new LerClientes().dadosClientes();

    JButton btnAtualizar = new JButton("Atualizar");

    public ListaClientes() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(btnAtualizar);

        painel.add(painelBotoes);

        String[] colunas = { "Nome", "CPF" };

        JTable tabela = new JTable(clientes, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
    }

    public void eventos() {
        btnAtualizar.addActionListener(e -> {
            clientes = new LerClientes().dadosClientes();
            painel.removeAll();
            inicializar();
        });
    }
}