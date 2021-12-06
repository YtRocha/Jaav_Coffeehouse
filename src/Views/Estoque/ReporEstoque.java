package Views.Estoque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Produtos.AchaCodigoQuantidade;

import Models.Produtos.RepoeNoEstoque;

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

public class ReporEstoque extends AbaProdutos implements Formulario {

    JLabel labelNome = new JLabel("Digite o nome do produto:");
    JTextField campoNome = new JTextField(10);

    JLabel labelQuantidade = new JLabel("Digite a quantidade:");
    JTextField campoQuantidade = new JTextField(10);

    JButton botaoRepor = new JButton("Repor");

    public ReporEstoque() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BorderLayout());

        botaoRepor.setPreferredSize(new Dimension(120, 30));
        botaoRepor.setFont(new Font("Arial", Font.BOLD, 14));
        botaoRepor.setFocusPainted(false);
        botaoRepor.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel painelRepor = new JPanel(new GridLayout(12, 2));
        JPanel leftSpace = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightSpace = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel rodape = new JPanel();

        
        painelRepor.add(labelNome);
        painelRepor.add(campoNome);
        painelRepor.add(labelQuantidade);
        painelRepor.add(campoQuantidade);
        
        

        rodape.add(botaoRepor);
        painel.add(leftSpace, BorderLayout.LINE_START);
        painel.add(rightSpace, BorderLayout.LINE_END);
        painel.add(painelRepor, BorderLayout.CENTER);

        painel.add(rodape, BorderLayout.PAGE_END);
    }

    public void eventos() {
        botaoRepor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNome.getText().equals("") || campoQuantidade.getText().equals("") ) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    try {
                        if (Integer.parseInt(campoQuantidade.getText()) > 0) {
                            
                            AchaCodigoQuantidade achar = new AchaCodigoQuantidade(campoNome.getText().toLowerCase()
                            ,"src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json");
                            achar.acharCodigoQuantidade();
                            if(achar.getCodigo() !=null){
                            RepoeNoEstoque repor = new RepoeNoEstoque(achar.getCodigo(),
                            Integer.parseInt(campoQuantidade.getText()));
                            repor.repor();
                            campoNome.setText("");
                            campoQuantidade.setText("");
                            achar.resetCodigo();
                        }else{
                            JOptionPane.showMessageDialog(null, "Produto nao cadastrado");
                        }
                            

                        } else {
                            JOptionPane.showMessageDialog(null, "Insira numeros validos!");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao repor produto: " + ex.getMessage());
                    }
                }
            }
        });
    }
}
