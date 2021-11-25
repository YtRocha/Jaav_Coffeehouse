package Views.Vendas;

import javax.swing.*;

import Models.Vendas.LerVendas;

public class ListaVendas extends AbaVendas {
    Object [][] vendas = new LerVendas().dadosVendas();

    public ListaVendas() {
        inicializar();
    }

    public void inicializar(){

        String [] colunas = { "Produto", "Preço", "Quantidade" };

        JTable tabela = new JTable(vendas, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        
        painel.add(scroll);
    }
}