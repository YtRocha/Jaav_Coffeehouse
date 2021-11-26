package Views.Clientes;

import javax.swing.*;

import Views.Formulario;

public class CadastrarClientes extends AbaClientes implements Formulario {
    
    JLabel labelTitulo = new JLabel("Cadastro de Clientes");
    JTextField textFieldNome = new JTextField();
    
    public CadastrarClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

    @Override
    public void eventos() {
        // TODO Implementar eventos
        
    }

}
