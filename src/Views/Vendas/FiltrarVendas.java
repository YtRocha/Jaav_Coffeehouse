package Views.Vendas;

import javax.swing.*;
import java.awt.BorderLayout;

import Models.Vendas.LerVendas;
import Views.Formulario;

public class FiltrarVendas extends AbaVendas implements Formulario {
    Object [][] vendas = new LerVendas().dadosVendasIdentificadas(null);

    JLabel lblFiltrarVendas = new JLabel("Digite um CPF para filtrar:");
    JTextField txtFiltrarVendas = new JTextField(10);
    JButton btnFiltrarVendas = new JButton("Filtrar");

    JPanel pnlPesquisa = new JPanel( new BorderLayout() );

    JPanel pnlTabela = new JPanel();

    public FiltrarVendas() {
        inicializar();
        eventos();
    }

    public void inicializar(){
        painel.setLayout(new BorderLayout());
        painel.add(this.getPnlPesquisa(), BorderLayout.PAGE_START);
        painel.add(this.getPnlTabela(), BorderLayout.CENTER);
    }
    
    public JPanel getPnlPesquisa(){
        pnlPesquisa.add(lblFiltrarVendas, BorderLayout.PAGE_START);
        pnlPesquisa.add(txtFiltrarVendas, BorderLayout.CENTER);
        pnlPesquisa.add(btnFiltrarVendas, BorderLayout.PAGE_END);

        return pnlPesquisa;
    }

    public JPanel getPnlTabela(){
        pnlTabela.setLayout(new BorderLayout());

        String [] colunas = { "Produto", "Preço", "Quantidade", "Comprador" };

        JTable tabela = new JTable(vendas, colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        pnlTabela.add(scroll);

        return pnlTabela;
    }

    public void eventos(){
        btnFiltrarVendas.addActionListener(e -> {
            String cpf = txtFiltrarVendas.getText().trim();
            vendas = new LerVendas().dadosVendasIdentificadas(!cpf.equals("") ? cpf : null);
            pnlTabela.removeAll();
            inicializar();
            eventos();
        });
    }



}