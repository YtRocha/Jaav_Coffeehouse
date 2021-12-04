package Views.Clientes;

import javax.swing.JLabel;
import javax.swing.JTextField;

import Models.Clientes.ExcluiCliente;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.Formulario;

public class ExcluirClientes extends AbaClientes implements Formulario {
    JLabel labelCPF = new JLabel("Digite o CPF do cliente a ser excluído.");
    JTextField campoCPF = new JTextField(10);

    JButton botaoExcluir = new JButton("Excluir");

    public ExcluirClientes() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BorderLayout());

        botaoExcluir.setPreferredSize(new Dimension(120, 30));
        botaoExcluir.setFont(new Font("Arial", Font.BOLD, 14));
        botaoExcluir.setFocusPainted(false);
        botaoExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel painelCadastro = new JPanel(new GridLayout(12, 2));
        JPanel leftSpace = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightSpace = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel rodape = new JPanel();

        painelCadastro.add(labelCPF);
        painelCadastro.add(campoCPF);

        rodape.add(botaoExcluir);
        painel.add(leftSpace, BorderLayout.LINE_START);
        painel.add(rightSpace, BorderLayout.LINE_END);
        painel.add(painelCadastro, BorderLayout.CENTER);

        painel.add(rodape, BorderLayout.PAGE_END);
    }

    public void eventos() {
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExcluiCliente excluiCliente = new ExcluiCliente(campoCPF.getText());
                excluiCliente.excluir();
            }
        });
    }
}