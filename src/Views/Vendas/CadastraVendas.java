package Views.Vendas;

import javax.swing.*;

public class CadastraVendas extends AbaVendas {
    JLabel labelTitulo = new JLabel("Cadastro de Vendas");

    public CadastraVendas() {
        inicializar();
    }

    public void inicializar(){
        painel.add(labelTitulo);
    }

}