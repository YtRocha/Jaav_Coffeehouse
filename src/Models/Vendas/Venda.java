package Models.Vendas;

import java.util.ArrayList;
import java.util.List;

import Models.Clientes.Cliente;
import Models.Produtos.Produto;

public class Venda {
    
    private Long id;

    private Cliente cliente;

    private double valor;

    private List<Produto> produtos = new ArrayList<Produto>();
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    

    public Venda() {
    }


    public Venda(Long id, Cliente cliente, double valor, List<Produto> produtos) {
        this.id = id;
        this.cliente = cliente;
        this.valor = valor;
        this.produtos = produtos;
    }

    public Venda(Long id, double valor, List<Produto> produtos) {
            this.id = id;
            this.valor = valor;
            this.produtos = produtos;
        }

}
