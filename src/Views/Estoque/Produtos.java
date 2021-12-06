package Views.Estoque;

import javax.swing.*;



import java.awt.*;

public class Produtos {
    JPanel painel = new JPanel(new GridLayout(1, 4));
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarCliente = new CadastrarAperitivo().getPainel();
    

    public Produtos() {
        inicializar();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void inicializar() {
        abas.addTab("Cadastrar clientes", painelCadastrarCliente);
        
        painel.add(abas);
    }
}