package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.ICadastraCliente;

public class CadastraCliente implements ICadastraCliente {
    private Cliente cliente = new Cliente();

    public CadastraCliente(String nome, String cpf) {
        cliente.setNome(nome);
        cliente.setCpf(cpf);
    }

    public boolean cadastrar() {
        return Database.cadastraCliente(this.cliente);
    }

    @Override
    public String geraId() {
        // TODO: implementar gerador de id.
        return null;
    }
}
