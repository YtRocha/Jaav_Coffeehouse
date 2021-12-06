package Views.Vendas;

import javax.swing.*;

import Models.Vendas.LerVendas;

public class ListaVendas extends AbaVendas {
    String[][] vendas = new LerVendas().dadosVendas();

    JButton btnAtualizar = new JButton("Atualizar");

    public ListaVendas() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(btnAtualizar);

        painel.add(painelBotoes);

        String[] colunas = { "Produto", "Preço", "Quantidade" };

        JTable tabela = new JTable(vendas, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
    }

    public void eventos() {
        btnAtualizar.addActionListener(e -> {
            vendas = new LerVendas().dadosVendas();
            painel.removeAll();
            inicializar();
        });
    }
}