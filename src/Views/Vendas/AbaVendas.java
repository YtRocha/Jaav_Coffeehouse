package Views.Vendas;

import javax.swing.JPanel;

public abstract class AbaVendas {
    protected JPanel painel = new JPanel();

    public JPanel getPainel() {
        return painel;
    }

    abstract void inicializar();
}
