package Models.Vendas;

import Database.Database;
import Models.Vendas.Interfaces.ICadastraVenda;
import Utils.Validators.Validator;

public class CadastraVenda implements ICadastraVenda {
    private Venda venda = new Venda();

    public CadastraVenda(String produto, double valor, int quantidade, String cpf) {
        venda.setProduto(produto);
        if (Validator.isCpfValid(cpf)) {
            venda.setCpf(cpf);
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
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
        if (venda.getProduto() != null &&
                venda.getValor() > 0) {
            return Database.cadastraVenda(this.venda);
        }
        return false;
    }
}
