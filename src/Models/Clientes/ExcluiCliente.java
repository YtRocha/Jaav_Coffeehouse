package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.IExcluiCliente;

public class ExcluiCliente implements IExcluiCliente {

    private String cpf;

    public ExcluiCliente(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean excluir() {
        return Database.excluiCliente(cpf);
    }
}
