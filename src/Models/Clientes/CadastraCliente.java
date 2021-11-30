package Models.Clientes;

import Utils.Txt.EscreverArquivo;

public class CadastraCliente {
    private Cliente cliente = new Cliente();
    private String database = "src/Database/clientes.txt";

    public CadastraCliente(String nome, String cpf) {
        cliente.setNome(nome);
        cliente.setCpf(cpf);
    }

    // TODO: adicionar gerador de ID.
    public void cadastrar() {
        String linha = cliente.getNome() + " | " + cliente.getCpf();

        EscreverArquivo arquivo = new EscreverArquivo(database, linha);
        arquivo.escreverArquivo();
    }
}
