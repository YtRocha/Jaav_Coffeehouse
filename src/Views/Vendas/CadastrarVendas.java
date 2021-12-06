
package Views.Vendas;

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
import java.io.File;

import Models.Produtos.AchaCodigoQuantidade;
import Models.Produtos.AlteraQuantidadeProduto;
import Models.Vendas.CadastraVenda;

public class CadastrarVendas extends AbaVendas {
    JLabel labelProduto = new JLabel("Digite o nome do produto:");
    JTextField campoProduto = new JTextField(10);

    JLabel labelQuantidade = new JLabel("Digite a quantidade vendida:");
    JTextField campoQuantidade = new JTextField(10);

    JLabel labelValor = new JLabel("Digite o valor do produto:");
    JTextField campoValor = new JTextField(10);

    JLabel labelCliente = new JLabel("Digite o CPF do comprador:");
    JTextField campoCliente = new JTextField(10);

    JButton botaoCadastrar = new JButton("Cadastrar");

    public CadastrarVendas() {
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

        painelCadastro.add(labelProduto);
        painelCadastro.add(campoProduto);
        painelCadastro.add(labelQuantidade);
        painelCadastro.add(campoQuantidade);
        painelCadastro.add(labelValor);
        painelCadastro.add(campoValor);
        painelCadastro.add(labelCliente);
        painelCadastro.add(campoCliente);

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
                String cpf = campoCliente.getText();
                String produto = campoProduto.getText();
                int quantidade = Integer.parseInt(campoQuantidade.getText());
                double valor = Double.parseDouble(campoValor.getText());

                if (!cpf.equals("")) {
                    try {
                        AchaCodigoQuantidade acharCodigoQuantidade = new AchaCodigoQuantidade(produto,
                                "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                                        + "estoque.json");
                        acharCodigoQuantidade.acharCodigoQuantidade();
                        String codigo = acharCodigoQuantidade.getCodigo();
                        int quantidadeEstoque = acharCodigoQuantidade.getQuantidade();
                        if (codigo != null) {
                            if (quantidadeEstoque >= quantidade) {
                                AlteraQuantidadeProduto alteraQuantidadeProduto = new AlteraQuantidadeProduto(codigo,
                                        quantidade, false);
                                alteraQuantidadeProduto.alterar();
                                CadastraVenda cadastrarVendas = new CadastraVenda(produto, valor, quantidade, cpf);
                                cadastrarVendas.cadastrar();
                                campoCliente.setText("");
                                campoProduto.setText("");
                                campoQuantidade.setText("");
                                campoValor.setText("");
                                JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Quantidade insuficiente... venda cancelada. a quantidade em estoque e: "
                                                + quantidadeEstoque);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto nao encontrado!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "CPF inválido!");
                    }
                } else {
                    try {
                        AchaCodigoQuantidade acharCodigoQuantidade = new AchaCodigoQuantidade(produto,
                                "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                                        + "estoque.json");
                        acharCodigoQuantidade.acharCodigoQuantidade();
                        String codigo = acharCodigoQuantidade.getCodigo();
                        int quantidadeEstoque = acharCodigoQuantidade.getQuantidade();
                        if (codigo != null) {
                            if (quantidadeEstoque >= quantidade) {
                                AlteraQuantidadeProduto alteraQuantidadeProduto = new AlteraQuantidadeProduto(codigo,
                                        quantidade, false);
                                alteraQuantidadeProduto.alterar();
                                CadastraVenda cadastrarVendas = new CadastraVenda(produto, valor, quantidade);
                                cadastrarVendas.cadastrar();
                                campoCliente.setText("");
                                campoProduto.setText("");
                                campoQuantidade.setText("");
                                campoValor.setText("");
                                JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Quantidade insuficiente... venda cancelada. a quantidade em estoque e: "
                                                + quantidadeEstoque);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Produto nao encontrado!");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "CPF inválido!");
                    }
                }
            }
        });
    }
}