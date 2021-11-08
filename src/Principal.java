
import javax.swing.*;
import java.awt.*;

import Views.Clientes.*;

public class Principal {
    public static void main(String[] args) {
        JTabbedPane principalAbas = new JTabbedPane();
        /*
            Aba Vendas
                - Cadastrar vendas
                - Cadastrar vendas sem os dados do(a) cliente
                - Listar todas as vendas
        */
        principalAbas.addTab("Vendas", new JPanel());
        /*
            Aba Clientes
                - Cadastrar/excluir um(a) cliente
                - Listar os(as) clientes cadastrados e excluidos
        */
        principalAbas.addTab("Clientes", new JPanel());
        /*
            Aba compras
                - Listar compras de um(a) determinado(a) cliente
        */  
        principalAbas.addTab("Compras", new JPanel());
        /*
            Aba produtos
                - Cadastrar produtos
                - Aumentar a quantidade de produtos no estoque
                - Listar produtos por categorias
                - Listar produtos exclu�dos ou fora do estoque
                - Listar todos os produtos cadastrados
                - Listar os produtos dispon�veis no estoque
        */
        principalAbas.addTab("Produtos", new JPanel());

        JFrame tela = new JFrame("JAAV Coffee House System");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.add(principalAbas);
        tela.setMinimumSize(new Dimension(800, 600));
        tela.setVisible(true);
        
    }
}
