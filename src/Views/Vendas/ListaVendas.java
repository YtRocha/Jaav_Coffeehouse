package Views.Vendas;

import javax.swing.*;

public class ListaVendas extends AbaVendas {
    JLabel labelTitulo = new JLabel("Lista de Vendas");

    public ListaVendas() {
        inicializar();
    }

    public void inicializar(){
        painel.add(new JLabel("Lista de vendas"))
                .setBounds(10, 10, 100, 20);
    }

}