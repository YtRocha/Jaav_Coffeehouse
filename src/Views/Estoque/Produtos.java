package Views.Estoque;

import javax.swing.*;

import java.awt.*;

public class Produtos {
    JPanel painel = new JPanel(new GridLayout(1, 4));
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarAperitivo = new CadastrarAperitivo().getPainel();
    JPanel painelCadastrarGrao = new CadastrarGrao().getPainel();
    JPanel painelCadastrarBebida = new CadastrarBebida().getPainel();

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

        painel.add(abas);
    }
}