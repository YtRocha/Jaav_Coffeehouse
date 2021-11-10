package Views.Vendas;

import javax.swing.*;

public class CadastrarVendas extends AbaVendas {
    JLabel labelTitulo = new JLabel("Cadastro de Vendas");

    public CadastrarVendas() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

}