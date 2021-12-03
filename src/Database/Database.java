package Database;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Models.Clientes.Cliente;
import Models.Produtos.Aperitivo;
import Models.Produtos.Bebida;
import Models.Produtos.Grao;
import Models.Vendas.Venda;
import Utils.JSON.EscreverJSON;
import Utils.JSON.LerJSON;
import Utils.Txt.EscreverArquivo;
import Utils.Txt.LerArquivo;

public class Database {

    public static LerArquivo vendas = new LerArquivo("src/Database/Content/vendas.txt");
    public static LerArquivo vendas_identificadas = new LerArquivo("src/Database/Content/vendas_identificadas.txt");
    public static LerArquivo clientes = new LerArquivo("src/Database/Content/clientes.txt");
    public static LerArquivo clientes_excluidos = new LerArquivo("src/Database/Content/clientes_excluidos.txt");

    public static String[][] dadosVendas() {
        String[] _vendas = vendas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];

        for (String venda : _vendas) {
            String[] dados_venda = venda.split("\\|");
            dados.add(dados_venda);

            System.out.println(venda);
        }
        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static String[][] dadosVendasIdentificadas(String filtrar_cpf) {
        String[] _vendas = vendas_identificadas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];

        for (String venda : _vendas) {
            String[] dados_venda = venda.split("\\|");

            if (filtrar_cpf != null) {
                if (dados_venda[3].trim().equals(filtrar_cpf)) {
                    dados.add(dados_venda);
                }
            } else {
                dados.add(dados_venda);
            }
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static boolean cadastraVenda(Venda venda) {
        String database;
        String linha;

        if (venda.getCpf() == null) {
            database = "src/Database/Content/vendas.txt";
            linha = venda.getProduto() + " | " + venda.getValor() + " | " + venda.getQuantidade();
        } else {
            database = "src/Database/Content/vendas_identificadas.txt";
            linha = venda.getProduto() + " | " + venda.getValor() + " | " + venda.getQuantidade() + " | "
                    + venda.getCpf();
        }

        EscreverArquivo arquivo = new EscreverArquivo(database, linha);
        return arquivo.escreverArquivo();
    }

    public static String[][] dadosClientes() {
        String[] _clientes = clientes.lerArquivo().split("\n");

        ArrayList<String[]> dados = new ArrayList<String[]>();

        String[][] dados_array = new String[dados.size()][];

        for (String cliente : _clientes) {
            String[] dados_cliente = cliente.split("\\|");
            dados.add(dados_cliente);
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static String[][] dadosClientesExcluidos() {
        String[] _clientes = clientes_excluidos.lerArquivo().split("\n");

        ArrayList<String[]> dados = new ArrayList<String[]>();

        String[][] dados_array = new String[dados.size()][];

        for (String cliente : _clientes) {
            String[] dados_cliente = cliente.split("\\|");
            dados.add(dados_cliente);
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    // TODO: Implementar metodo para excluir cliente
    public static boolean excluiCliente() {
        return true;
    }

    public static boolean cadastraCliente(Cliente cliente) {
        String database = "src/Database/Content/clientes.txt";
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


    public static JSONArray  leProduto(){
    
        String database = "src/Database/Content/estoque.json";

        
            LerJSON leitor = new LerJSON(database);
            leitor.lerJSON();
            JSONArray jarray = new JSONArray();
            jarray = leitor.getJarray();
            return jarray;

    }

    public static boolean excluiProduto(){
        return true;
    }

    public static boolean cadastraAperitivo(Aperitivo aperitivo){
    
        String database = "src/Database/Content/estoque.json";

        try{
            JSONObject objeto = new JSONObject();
            objeto.put("nome", aperitivo.getNome());
            objeto.put("preco", aperitivo.getPreco());
            objeto.put("quantidade", aperitivo.getQuantidade());
            objeto.put("categoria", aperitivo.getCategoria());
            objeto.put("tamanho", aperitivo.getTamanho());
        
            EscreverJSON escrever = new EscreverJSON(database,  objeto);
            escrever.escreverJson();

            return true;
        } catch(Exception e){
            System.out.println("Erro ao cadastrar produto");
            return false;
        }
        
    }

    public static boolean cadastraGrao(Grao grao){

        String database = "src/Database/Content/estoque.json";

        try{     
            JSONObject objeto = new JSONObject();
            objeto.put("nome", grao.getNome());
            objeto.put("preco", grao.getPreco());
            objeto.put("quantidade", grao.getQuantidade());
            objeto.put("categoria", grao.getCategoria());
            objeto.put("marca", grao.getMarca());
            objeto.put("gourmet", grao.getGourmet());
            objeto.put("torra", grao.getTorra());
            
            
            EscreverJSON escrever = new EscreverJSON(database,  objeto);
            escrever.escreverJson();

            return true;
        } catch(Exception e){
            System.out.println("Erro ao cadastrar produto");
            return false;
        }

    }

    public static boolean cadastraBebida(Bebida bebida){

        String database = "src/Database/Content/estoque.json";

        try{
            JSONObject objeto = new JSONObject();
            objeto.put("nome", bebida.getNome());
            objeto.put("preco", bebida.getPreco());
            objeto.put("quantidade", bebida.getQuantidade());
            objeto.put("categoria", bebida.getCategoria());
            
            
            
            EscreverJSON escrever = new EscreverJSON(database,  objeto);
            escrever.escreverJson();

            return true;
        } catch(Exception e){
            System.out.println("Erro ao cadastrar produto");
            return false;
        }

    }
}

