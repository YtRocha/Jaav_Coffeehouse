package Models.Clientes;

import Database.Database;
import Models.Clientes.Interfaces.ICadastraCliente;
import Utils.Validators.Validator;

public class CadastraCliente implements ICadastraCliente {
    private Cliente cliente = new Cliente();

    public CadastraCliente(String nome, String cpf) {
        cliente.setNome(nome);
        if (Validator.isCpfValid(cpf)) {
            cliente.setCpf(cpf);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public boolean cadastrar() {
        return Database.cadastraCliente(this.cliente);
    }

    
}
