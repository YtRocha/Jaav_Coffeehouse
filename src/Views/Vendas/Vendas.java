package Views.Vendas;

import javax.swing.*;
import java.awt.*;

public class Vendas {
    JPanel painel = new JPanel( new GridLayout(1,1) );
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarVendas = new CadastrarVendas().getPainel();
    JPanel painelListarVendas = new ListaVendas().getPainel();

    public Vendas() {
        inicializar();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void inicializar(){
        painel.add(abas);
        abas.addTab("Cadastrar Vendas", painelCadastrarVendas);
        abas.addTab("Listar Vendas", painelListarVendas);

        painel.add(abas);
    }
}