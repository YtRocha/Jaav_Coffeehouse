package Views.Clientes;

import javax.swing.*;

import Models.Clientes.LerClientesExcluidos;

public class ListaClientesExcluidos extends AbaClientes {
    String[][] clientes_excluidos = new LerClientesExcluidos().dadosClientes();
    JButton btnAtualizar = new JButton("Atualizar");

    public ListaClientesExcluidos() {
        inicializar();
    }

    public void inicializar() {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(btnAtualizar);

        painel.add(painelBotoes);
        String[] colunas = { "Nome", "CPF", "Data de exlusão" };

        JTable tabela = new JTable(clientes_excluidos, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
    }

    public void eventos() {
        btnAtualizar.addActionListener(e -> {
            clientes_excluidos = new LerClientesExcluidos().dadosClientes();
            painel.removeAll();
            inicializar();
        });
    }
}