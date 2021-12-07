package Views.Estoque;

import javax.swing.*;
import java.awt.BorderLayout;
import java.io.File;

import Models.Produtos.LerProdutos;
import Views.Formulario;

public class ListaCategorias extends AbaProdutos implements Formulario {
    String[][] produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json").dadosProdutos();

    JLabel lblFiltrarCategoria = new JLabel("Digite uma categoria para filtrar:");
    JTextField txtFiltrarCategoria = new JTextField(10);
    JButton btnFiltrarCategoria = new JButton("Filtrar");
    JButton btnAtualizar = new JButton("Atualizar");

    JPanel pnlPesquisa = new JPanel(new BorderLayout());

    JPanel pnlTabela = new JPanel();

    public  ListaCategorias() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BorderLayout());
        painel.add(this.getPnlPesquisa(), BorderLayout.PAGE_START);
        painel.add(this.getPnlTabela(), BorderLayout.CENTER);
    }

    public JPanel getPnlPesquisa() {
        JPanel btn_container = new JPanel();
        btn_container.add(btnFiltrarCategoria);
        btn_container.add(btnAtualizar);
        pnlPesquisa.add(lblFiltrarCategoria, BorderLayout.PAGE_START);
        pnlPesquisa.add(txtFiltrarCategoria, BorderLayout.CENTER);
        pnlPesquisa.add(btn_container, BorderLayout.LINE_END);

        return pnlPesquisa;
    }

    public JPanel getPnlTabela() {
        pnlTabela.setLayout(new BorderLayout());

        String[] colunas = {"Codigo", "Nome", "Preço", "Categorias", "Quantidade", "Tamanho", "Marca", "Torra",
                "Gourmet"};

        JTable tabela = new JTable(produtos, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        pnlTabela.add(scroll);

        return pnlTabela;
    }

    public void eventos() {
        btnFiltrarCategoria.addActionListener(e -> {
            String categoria = txtFiltrarCategoria.getText().toLowerCase();
            produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json",
            categoria).dadosProdutosFiltrados();
            pnlTabela.removeAll();
            inicializar();
        });
        btnAtualizar.addActionListener(e -> {
            produtos = new LerProdutos("src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json").dadosProdutos();
            pnlTabela.removeAll();
            inicializar();
        });
    }
}