package Models.Vendas;

import Database.Database;
import Models.Vendas.Interfaces.ICadastraVenda;

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
        return Database.cadastraVenda(this.venda);
    }
}
