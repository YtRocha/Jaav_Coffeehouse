package Views.Estoque;

import javax.swing.JPanel;

public abstract class AbaProdutos {
    protected JPanel painel = new JPanel();

    public JPanel getPainel() {
        return painel;
    }

    abstract void inicializar();
}
