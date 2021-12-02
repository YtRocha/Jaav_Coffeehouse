package Models.Vendas.Interfaces;

public interface ILerVendas {
    public String[][] dadosVendas();

    public String[][] dadosVendasIdentificadas(String filtrar_cpf);
}
