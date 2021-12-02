package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.ILerClientes;

public class LerClientes implements ILerClientes {
    public String[][] dadosClientes() {
        return Database.dadosClientes();
    }
}
