package Views.Estoque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Models.Produtos.AchaCodigoQuantidade;
import Models.Produtos.ExcluiProduto;

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

public class ExcluiProdutos extends AbaProdutos implements Formulario {

    JLabel labelNome = new JLabel("Digite o nome do produto:");
    JTextField campoNome = new JTextField(10);

    JButton botaoExcluir = new JButton("Excluir");

    public ExcluiProdutos() {
        inicializar();
        eventos();
    }

    public void inicializar() {
        painel.setLayout(new BorderLayout());

        botaoExcluir.setPreferredSize(new Dimension(120, 30));
        botaoExcluir.setFont(new Font("Arial", Font.BOLD, 14));
        botaoExcluir.setFocusPainted(false);
        botaoExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel painelExcluir = new JPanel(new GridLayout(12, 2));
        JPanel leftSpace = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel rightSpace = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel rodape = new JPanel();

        
        painelExcluir.add(labelNome);
        painelExcluir.add(campoNome);
        
        
        

        rodape.add(botaoExcluir);
        painel.add(leftSpace, BorderLayout.LINE_START);
        painel.add(rightSpace, BorderLayout.LINE_END);
        painel.add(painelExcluir, BorderLayout.CENTER);

        painel.add(rodape, BorderLayout.PAGE_END);
    }

    public void eventos() {
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoNome.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha o campo!");
                } else {
                    try {
                            
                            AchaCodigoQuantidade achar = new AchaCodigoQuantidade(campoNome.getText().toLowerCase()
                            ,"src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json");
                            achar.acharCodigoQuantidade();
                            AchaCodigoQuantidade acharForaE = new AchaCodigoQuantidade(campoNome.getText().toLowerCase()
                            ,"src"+File.separator+"Database"+File.separator+"Content"+File.separator+"fora_de_estoque.json");
                            acharForaE.acharCodigoQuantidade();
                            if(achar.getCodigo() != null){
                                ExcluiProduto excluiProduto = new ExcluiProduto(achar.getCodigo(),
                                "src"+File.separator+"Database"+File.separator+"Content"+File.separator+"estoque.json");
                                excluiProduto.excluir();
                                
                                campoNome.setText("");
                                achar.resetCodigo();
                                
                        } else if(acharForaE.getCodigo() != null){
                                JOptionPane.showMessageDialog(null, "Produto fora de estoque, reponha-o para ser excluido");
                            
                                campoNome.setText("");
                                acharForaE.resetCodigo();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Produto nao cadastrado");
                        }
                            

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + ex.getMessage());
                    }
                }
            }
        });
    }
}
