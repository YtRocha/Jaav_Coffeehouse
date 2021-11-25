package Views.Vendas;

import javax.swing.*;

import Models.Vendas.LerVendas;

public class FiltrarVendas extends AbaVendas {
    Object [][] vendas = new LerVendas().dadosVendasIdentificadas();

    public FiltrarVendas() {
        inicializar();
    }

    public void inicializar(){

        String [] colunas = { "Produto", "Preço", "Quantidade", "Comprador" };
        
        JTable tabela = new JTable(vendas, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        painel.add(scroll);

    }

}