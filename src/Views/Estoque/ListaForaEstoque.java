package Views.Estoque;

import java.io.File;

import javax.swing.*;

import Models.Produtos.LerProdutos;


public class ListaForaEstoque extends AbaProdutos {
    String[][] produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json").dadosProdutos();

    JButton btnAtualizar = new JButton("Atualizar");

    public ListaForaEstoque() {
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

        JTable tabela = new JTable(produtos, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        painel.add(scroll);
    }

    public void eventos() {
        btnAtualizar.addActionListener(e -> {
            produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json").dadosProdutos();
            painel.removeAll();
            inicializar();
        });
    }
}