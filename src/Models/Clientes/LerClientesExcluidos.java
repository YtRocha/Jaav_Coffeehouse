package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.ILerClientes;
import Utils.Txt.LerArquivo;

public class LerClientesExcluidos implements ILerClientes {
    public String[][] dadosClientes() {
        return Database.dadosClientesExcluidos();
    }
}
