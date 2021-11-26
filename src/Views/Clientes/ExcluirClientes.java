
package Views.Clientes;

import javax.swing.*;

import Views.Formulario;

public class ExcluirClientes extends AbaClientes implements Formulario{
    
    JLabel labelTitulo = new JLabel("Excluir clientes");

    public ExcluirClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

    @Override
    public void eventos() {
        // TODO Implement this method
        
    }

}
