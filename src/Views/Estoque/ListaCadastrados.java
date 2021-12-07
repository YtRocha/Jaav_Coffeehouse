package Views.Estoque;

import java.io.File;

import javax.swing.*;

import Models.Produtos.LerProdutos;


public class ListaCadastrados extends AbaProdutos {
    String[][] produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json").dadosProdutos();
    String[][] foraEstoque = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json").dadosProdutos();

    JButton btnAtualizar = new JButton("Atualizar");

    public ListaCadastrados() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
        painelBotoes.add(btnAtualizar);

        painel.add(painelBotoes);

        String[] colunas = { "Codigo", "Nome", "Preço", "Categorias", "Quantidade", "Tamanho", "Marca", "Torra",
                "Gourmet" };

        JLabel labelTabela = new JLabel("Produtos em estoque:");
        JTable tabela = new JTable(produtos, colunas);
        JLabel labelTabela2 = new JLabel("Produtos em falta:");
        JTable tabela2 = new JTable(foraEstoque, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        JScrollPane scroll2 = new JScrollPane(tabela2);

        painel.add(labelTabela);
        painel.add(scroll);
        painel.add(labelTabela2);
        painel.add(scroll2);
    }

    public void eventos() {
        btnAtualizar.addActionListener(e -> {
            produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json").dadosProdutos();
            foraEstoque = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json").dadosProdutos();
            painel.removeAll();
            inicializar();
        });
    }
}