package Views.Estoque;

import javax.swing.*;

import java.awt.*;

public class Produtos {
    JPanel painel = new JPanel(new GridLayout(1, 4));
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarAperitivo = new CadastrarAperitivo().getPainel();
    JPanel painelCadastrarGrao = new CadastrarGrao().getPainel();
    JPanel painelCadastrarBebida = new CadastrarBebida().getPainel();
    JPanel painelReporEstoque = new ReporEstoque().getPainel();
    JPanel painelExcluiProduto = new ExcluiProdutos().getPainel();
    JPanel painelListarProdutos = new ListaProdutos().getPainel();
    JPanel painelListaExcluidos = new ListaExcluidos().getPainel();
    JPanel painelListaForaEstoque = new ListaForaEstoque().getPainel();
    JPanel painelListaCadastrados = new ListaCadastrados().getPainel();
    JPanel painelListaCategorias =  new ListaCategorias().getPainel();

    public Produtos() {
        inicializar();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void inicializar() {
        abas.addTab("Cadastrar Aperitivos", painelCadastrarAperitivo);
        abas.addTab("Cadastrar Graos", painelCadastrarGrao);
        abas.addTab("Cadastrar Bebidas", painelCadastrarBebida);
        abas.addTab("Repor Produto", painelReporEstoque);
        abas.addTab("Excluir Produtos", painelExcluiProduto);
        abas.addTab("Listar Cadastrados", painelListaCadastrados);
        abas.addTab("Listar Estoque", painelListarProdutos);
        abas.addTab("Filtrar Produtos", painelListaCategorias);
        abas.addTab("Listar Em falta", painelListaForaEstoque);
        
        abas.addTab("Listar Excluidos", painelListaExcluidos);

        painel.add(abas);
    }
}