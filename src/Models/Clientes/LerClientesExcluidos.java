package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.ILerClientes;

public class LerClientesExcluidos implements ILerClientes {
    public String[][] dadosClientes() {
        return Database.dadosClientesExcluidos();
    }
}
