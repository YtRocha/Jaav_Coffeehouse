package Views.Clientes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import Models.Clientes.CadastraCliente;

public class CadastrarClientes extends AbaClientes implements Formulario {
    JLabel labelNome = new JLabel("Digite o nome do cliente:");
    JTextField campoNome = new JTextField(10);

    JLabel labelCPF = new JLabel("Digite CPF do cliente:");
    JTextField campoCPF = new JTextField(10);

    JButton botaoCadastrar = new JButton("Cadastrar");

    public CadastrarClientes() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BorderLayout());

        botaoCadastrar.setPreferredSize(new Dimension(120, 30));
        botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoCadastrar.setFocusPainted(false);
        botaoCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel painelCadastro = new JPanel(new GridLayout(12, 2));
        JPanel leftSpace = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightSpace = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel rodape = new JPanel();

        painelCadastro.add(labelNome);
        painelCadastro.add(campoNome);
        painelCadastro.add(labelCPF);
        painelCadastro.add(campoCPF);

        rodape.add(botaoCadastrar);
        painel.add(leftSpace, BorderLayout.LINE_START);
        painel.add(rightSpace, BorderLayout.LINE_END);
        painel.add(painelCadastro, BorderLayout.CENTER);

        painel.add(rodape, BorderLayout.PAGE_END);
    }

    public void eventos() {
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNome.getText().equals("") || campoCPF.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    try {
                        CadastraCliente cadastra_cliente = new CadastraCliente(campoNome.getText(), campoCPF.getText());
                        cadastra_cliente.cadastrar();
                        campoNome.setText("");
                        campoCPF.setText("");
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + ex.getMessage());
                    }
                }
            }
        });
    }
}