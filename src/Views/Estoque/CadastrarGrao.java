package Views.Estoque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Produtos.CadastraGrao;

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

public class CadastrarGrao extends AbaProdutos implements Formulario{
    
    JLabel labelNome = new JLabel("Digite o nome do grao:");
    JTextField campoNome = new JTextField(10);

    JLabel labelCodigo = new JLabel("Digite o codigo do grao:");
    JTextField campoCodigo = new JTextField(10);

    JLabel labelPreco = new JLabel("Digite o preço:");
    JTextField campoPreco = new JTextField(10);

    JLabel labelQuantidade = new JLabel("Digite a quantidade:");
    JTextField campoQuantidade = new JTextField(10);

    JLabel labelCategorias = new JLabel("Digite as categorias:");
    JTextField campoCategorias = new JTextField(10);

    JLabel labelMarca = new JLabel("Digite a marca:");
    JTextField campoMarca = new JTextField(10);

    JLabel labelGourmet = new JLabel("O grao e gourmet?");
    JTextField campoGourmet = new JTextField(10);

    JLabel labelTorra = new JLabel("Digite a torra:");
    JTextField campoTorra = new JTextField(10);

    JButton botaoCadastrar = new JButton("Cadastrar");

    public CadastrarAperitivo() {
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
        painelCadastro.add(labelCodigo);
        painelCadastro.add(campoCodigo);
        painelCadastro.add(labelPreco);
        painelCadastro.add(campoPreco);
        painelCadastro.add(labelQuantidade);
        painelCadastro.add(campoQuantidade);
        painelCadastro.add(labelCategorias);
        painelCadastro.add(campoCategorias);
        painelCadastro.add(labelMarca);
        painelCadastro.add(campoMarca);
        painelCadastro.add(labelGourmet);
        painelCadastro.add(campoGourmet);
        painelCadastro.add(labelTorra);
        painelCadastro.add(campoTorra);
        

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
                if (campoNome.getText().equals("") || campoCodigo.getText().equals("") || campoPreco.getText().equals("")
                || campoQuantidade.getText().equals("") || campoCategorias.getText().equals("") || campoMarca.getText().equals("")
                || campoGourmet.getText().equals("") || campoTorra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    try {
                    Boolean gourmet = false;
                    if(campoGourmet.getText().toLowerCase() == "sim"){
                        gourmet = true;
                    } else if(campoGourmet.getText().toLowerCase() == "nao"){
                        gourmet = false;
                    } else{
                        JOptionPane.showMessageDialog(null, "Insira sim ou nao para a pergunta sobre gourmet!");
                    }

                    if(Integer.parseInt(campoQuantidade.getText()) > 0 || Double.parseDouble(campoPreco.getText()) > 0){
                        CadastraGrao cadastraAperitivo = new CadastraGrao(campoCodigo.getText(), campoNome.getText(),
                        Double.parseDouble(campoPreco.getText()), Integer.parseInt(campoQuantidade.getText()),
                        campoCategorias.getText(), campoMarca.getText(), gourmet, campoTorra.getText());
                        cadastraAperitivo.cadastrar();
                        campoCodigo.setText("");
                        campoNome.setText("");
                        campoPreco.setText("");
                        campoQuantidade.setText("");
                        campoCategorias.setText("");
                        campoMarca.setText("");
                        campoGourmet.setText("");
                        campoTorra.setText("");
                    }
                    else{
                            JOptionPane.showMessageDialog(null, "Insira numeros validos!");
                        }
                        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + ex.getMessage());
                }
                }
        }
    });
}
}
