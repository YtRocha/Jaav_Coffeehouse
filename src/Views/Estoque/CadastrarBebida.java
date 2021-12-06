package Views.Estoque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Produtos.CadastraBebida;
import Models.Produtos.ExisteCodigo;

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

import Views.Formulario;

public class CadastrarBebida extends AbaProdutos implements Formulario {

    JLabel labelNome = new JLabel("Digite o nome da bebida:");
    JTextField campoNome = new JTextField(10);

    JLabel labelCodigo = new JLabel("Digite o codigo da bebida:");
    JTextField campoCodigo = new JTextField(10);

    JLabel labelPreco = new JLabel("Digite o preço:");
    JTextField campoPreco = new JTextField(10);

    JLabel labelQuantidade = new JLabel("Digite a quantidade:");
    JTextField campoQuantidade = new JTextField(10);

    JLabel labelCategorias = new JLabel("Digite as categorias:");
    JTextField campoCategorias = new JTextField(10);


    JButton botaoCadastrar = new JButton("Cadastrar");

    public CadastrarBebida() {
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
                if (campoNome.getText().equals("") || campoCodigo.getText().equals("")
                        || campoPreco.getText().equals("")
                        || campoQuantidade.getText().equals("") || campoCategorias.getText().equals("")
                        ) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    try {
                        if (Integer.parseInt(campoQuantidade.getText()) > 0
                                || Double.parseDouble(campoPreco.getText()) > 0) {
                                    ExisteCodigo existe = new ExisteCodigo(campoCodigo.getText().toUpperCase(),
                                    "src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json");
                                    existe.existeEsseCodigo();
                                    ExisteCodigo existeForaE = new ExisteCodigo(campoCodigo.getText().toUpperCase(),
                                    "src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json");
                                    existeForaE.existeEsseCodigo();
                                    if(existe.getExiste() == null){
                                        if(existeForaE.getExiste() == null){
                                                CadastraBebida cadastraBebida = new CadastraBebida(campoCodigo.getText().toUpperCase(),
                                        campoNome.getText().toLowerCase(),
                                        Double.parseDouble(campoPreco.getText()),
                                        Integer.parseInt(campoQuantidade.getText()),
                                        campoCategorias.getText().toLowerCase());
                                        cadastraBebida.cadastrar();
                                        campoCodigo.setText("");
                                        campoNome.setText("");
                                        campoPreco.setText("");
                                        campoQuantidade.setText("");
                                        campoCategorias.setText("");
                                        } 
                                        else{JOptionPane.showMessageDialog(null, "Produto com esse codigo ja existe e esta fora de estoque!");}
                                    } else{JOptionPane.showMessageDialog(null, "Produto com esse codigo ja existe!");}
                                    
                            

                        } else {
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
