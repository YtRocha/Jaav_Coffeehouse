package Views.Clientes;

import javax.swing.*;
import java.awt.*;

public class Clientes {
    JPanel painel = new JPanel( new GridLayout(1,4) );
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarVendas = new CadastrarClientes().getPainel();
    JPanel painelExcluirVendas = new ExcluirClientes().getPainel();
    JPanel painelListarVendas = new ListaClientes().getPainel();

    public Clientes() {
        inicializar();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void inicializar(){
        abas.addTab("Cadastrar clientes", painelCadastrarVendas);
        abas.addTab("Excluir clientes", painelExcluirVendas);
        abas.addTab("Listar clientes", painelListarVendas);

        painel.add(abas);
    }
}