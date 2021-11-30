package Views.Clientes;

import javax.swing.*;

import Models.Vendas.LerVendas;
public class ListaClientes extends AbaClientes {
    // TODO: implementar model de dados.
    String[][] clientes_mock = {
            {"1", "João", "123456789", ""},
            {"2", "Maria", "987654321", ""},
            {"3", "Pedro", "123456789", ""},
            {"4", "Ana", "987654321", ""},
            {"5", "José", "123456789", ""},
            {"6", "Paula", "987654321", ""},
            {"7", "José", "123456789", ""},
            {"8", "Paula", "987654321", ""},
            {"9", "José", "123456789", ""},
            {"10", "Paula", "987654321", ""},
            {"11", "José", "123456789", ""}};

    public ListaClientes() {
        inicializar();
    }

    public void inicializar(){
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        String [] colunas = { "ID", "Nome", "CPF" };

        JTable tabela = new JTable(clientes_mock, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        
        painel.add(scroll);
    }
}