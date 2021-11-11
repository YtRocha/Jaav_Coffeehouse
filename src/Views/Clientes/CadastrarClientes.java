package Views.Clientes;

import javax.swing.*;

public class CadastrarClientes extends AbaClientes {
    
    JLabel labelTitulo = new JLabel("Cadastro de Clientes");
    JTextField textFieldNome = new JTextField();
    
    public CadastrarClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

}
