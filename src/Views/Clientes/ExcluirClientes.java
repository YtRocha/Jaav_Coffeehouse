
package Views.Clientes;

import javax.swing.*;

public class ExcluirClientes extends AbaClientes {
    
    JLabel labelTitulo = new JLabel("Excluir clientes");

    public ExcluirClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

}
