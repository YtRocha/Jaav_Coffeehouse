package Views.Clientes;

import javax.swing.*;
import java.awt.*;

public class Clientes {
    JPanel painel = new JPanel( new GridLayout(1,4) );
    JTabbedPane abas = new JTabbedPane();

    JPanel painelCadastrarCliente = new CadastrarClientes().getPainel();
    JPanel painelExcluirCliente = new ExcluirClientes().getPainel();
    JPanel painelListarCliente = new ListaClientes().getPainel();
    JPanel painelListarClientesExcluidos = new ListaClientesExcluidos().getPainel();

    public Clientes() {
        inicializar();
    }

    public JPanel getPainel() {
        return painel;
    }

    public void inicializar(){
        abas.addTab("Cadastrar clientes", painelCadastrarCliente);
        abas.addTab("Excluir clientes", painelExcluirCliente);
        abas.addTab("Listar clientes cadastrados", painelListarCliente);
        abas.addTab("Listar clientes excluidos", painelListarClientesExcluidos);

        painel.add(abas);
    }
}