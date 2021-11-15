package Models.Vendas;

import Utils.Txt.EscreverArquivo;

public class CadastraVenda {
    private Venda venda = new Venda();

    public CadastraVenda(String produto, String cpf, double valor, int quantidade) {
        venda.setProduto(produto);
        venda.setCpf(cpf);
        venda.setValor(valor);
        venda.setQuantidade(quantidade);
    }

    public CadastraVenda(String produto, double valor, int quantidade) {
        venda.setProduto(produto);
        venda.setCpf(null);
        venda.setValor(valor);
        venda.setQuantidade(quantidade);
    }

    public void cadastrar() {
        String database;
        String linha;

        if (venda.getCpf() == null) {
            database = "src\\Database\\vendas.txt";
            linha = venda.getProduto() + " | " + venda.getValor() + " | " + venda.getQuantidade();
        } else {
            database = "src\\Database\\vendas_identificadas.txt";
            linha = venda.getProduto() + " | " + venda.getValor() + " | " + venda.getQuantidade() + " | "
                    + venda.getCpf();
        }

        EscreverArquivo arquivo = new EscreverArquivo(database, linha);
        arquivo.escreverArquivo();
    }

    public static void main(String[] args) {
        CadastraVenda venda = new CadastraVenda("Café", "123.456.789-00", 2.50, 10);
        venda.cadastrar();
    }
}
