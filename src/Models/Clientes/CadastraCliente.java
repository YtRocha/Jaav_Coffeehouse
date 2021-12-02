package Models.Clientes;

import Models.Clientes.Interfaces.ICadastraCliente;
import Utils.Txt.EscreverArquivo;

public class CadastraCliente implements ICadastraCliente {
    private Cliente cliente = new Cliente();
    private String database = "src/Database/clientes.txt";

    public CadastraCliente(String nome, String cpf) {
        cliente.setNome(nome);
        cliente.setCpf(cpf);
    }

    public boolean cadastrar() {
        String linha = cliente.getNome() + " | " + cliente.getCpf();

        try {
            EscreverArquivo arquivo = new EscreverArquivo(database, linha);
            arquivo.escreverArquivo();
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente");
            return false;
        }
    }

    @Override
    public String geraId() {
        // TODO: implementar gerador de id.
        return null;
    }
}
