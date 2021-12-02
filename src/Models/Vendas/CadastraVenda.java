package Models.Vendas;

import Models.Vendas.Interfaces.ICadastraVenda;
import Utils.Txt.EscreverArquivo;

public class CadastraVenda implements ICadastraVenda {
    private Venda venda = new Venda();

    public CadastraVenda(String produto, double valor, int quantidade, String cpf) {
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

    public boolean cadastrar() {
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
        return arquivo.escreverArquivo();
    }
}
