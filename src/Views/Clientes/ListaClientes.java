package Views.Clientes;

import javax.swing.*;

public class ListaClientes extends AbaClientes {
    
    JLabel labelTitulo = new JLabel("Listar os clientes");

    public ListaClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

}
