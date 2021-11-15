package Views.Clientes;

import javax.swing.JPanel;

public abstract class AbaClientes {
    protected JPanel painel = new JPanel();

    public JPanel getPainel() {
        return painel;
    }

    abstract void inicializar();
}
