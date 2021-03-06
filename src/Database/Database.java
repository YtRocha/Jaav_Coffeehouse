package Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public static LerArquivo vendas = new LerArquivo(
            "src" + File.separator + "Database" + File.separator + "Content" + File.separator + "vendas.txt");
    public static LerArquivo vendas_identificadas = new LerArquivo("src" + File.separator + "Database" + File.separator
            + "Content" + File.separator + "vendas_identificadas.txt");
    public static LerArquivo clientes = new LerArquivo(
            "src" + File.separator + "Database" + File.separator + "Content" + File.separator + "clientes.txt");
    public static LerArquivo clientes_excluidos = new LerArquivo("src" + File.separator + "Database" + File.separator
            + "Content" + File.separator + "clientes_excluidos.txt");

    public static String[][] dadosVendas() {
        String[] _vendas = vendas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];
        for (String venda : _vendas) {
            if (!venda.equals("")) {
                String[] dados_venda = venda.split("\\|");
                dados.add(dados_venda);
            }
        }
        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static String[][] dadosVendasIdentificadas(String filtrar_cpf) {
        String[] _vendas = vendas_identificadas.lerArquivo().split("\n");
        ArrayList<String[]> dados = new ArrayList<String[]>();
        String[][] dados_array = new String[dados.size()][];

        for (String venda : _vendas) {
            if (!venda.equals("")) {
                String[] dados_venda = venda.split("\\|");
                if (filtrar_cpf != null) {
                    if (dados_venda[3].trim().equals(filtrar_cpf)) {
                        dados.add(dados_venda);
                    }
                } else {
                    dados.add(dados_venda);
                }
            }
        }
        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static boolean cadastraVenda(Venda venda) {
        String database;
        String linha;

        if (venda.getCpf() == null) {
            database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator + "vendas.txt";
            linha = venda.getProduto() + " | " + venda.getValor() + " | " + venda.getQuantidade();
        } else {
            database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                    + "vendas_identificadas.txt";
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
            if (!cliente.equals("")) {
                String[] dados_cliente = cliente.split("\\|");
                dados.add(dados_cliente);
            }
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static String[][] dadosClientesExcluidos() {
        String[] _clientes = clientes_excluidos.lerArquivo().split("\n");

        ArrayList<String[]> dados = new ArrayList<String[]>();

        String[][] dados_array = new String[dados.size()][];

        for (String cliente : _clientes) {
            if (!cliente.equals("")) {
                String[] dados_cliente = cliente.split("\\|");
                dados.add(dados_cliente);
            }
        }

        dados_array = dados.toArray(dados_array);
        return dados_array;
    }

    public static boolean excluiCliente(String cpf) {
        String[][] clientes = dadosClientes();

        ArrayList<String[]> clientes_filtrados = new ArrayList<String[]>();
        String[][] clientes_filtrados_array = new String[clientes_filtrados.size()][];

        String cliente_excluido = "";

        for (String[] cliente : clientes) {
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());

            if (cliente.length > 1) {
                if (cliente[1].trim().equals(cpf)) {
                    cliente_excluido = cliente[0].trim() + " | " + cliente[1].trim() + " | "
                            + timeStamp;
                } else {
                    clientes_filtrados.add(cliente);
                }
            }
        }

        EscreverArquivo clientes_excluidos_arquivo = new EscreverArquivo(
                "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                        + "clientes_excluidos.txt",
                cliente_excluido);
        clientes_excluidos_arquivo.escreverArquivo();

        clientes_filtrados_array = clientes_filtrados.toArray(clientes_filtrados_array);

        System.out.println(clientes_filtrados.size());

        String db = "src" + File.separator + "Database" + File.separator + "Content" + File.separator + "clientes.txt";

        EscreverArquivo clientes_arquivo = new EscreverArquivo(db, "");
        clientes_arquivo.limparArquivo();

        for (String[] cliente : clientes_filtrados_array) {
            clientes_arquivo = new EscreverArquivo(db,
                    (cliente[0].trim() + " | " + cliente[1].trim()));
            clientes_arquivo.escreverArquivo();
        }

        return true;
    }

    public static boolean cadastraCliente(Cliente cliente) {
        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "clientes.txt";
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

    public static boolean alteraQuantidadeProduto(String codigo, Integer quantidade, boolean somar) {
        JSONArray jarray = leProduto();
        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";
        int len = jarray.size();
        JSONObject objeto = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            if (quantidade > 0) {
                FileWriter json = new FileWriter(database);
                for (int elemento = 0; elemento < len; elemento++) {
                    objeto = (JSONObject) parser.parse(jarray.get(elemento).toString());
                    if (objeto.containsValue(codigo) == true) {
                        if (somar == true) {
                            objeto.replace("quantidade", objeto.get("quantidade"),
                                    Integer.parseInt(objeto.get("quantidade").toString()) + quantidade);
                            jarray.set(elemento, objeto);
                            json.write(jarray.toString());
                            json.close();
                        } else {
                            objeto.replace("quantidade", objeto.get("quantidade"),
                                    Integer.parseInt(objeto.get("quantidade").toString()) - quantidade);
                            if (Integer.parseInt(objeto.get("quantidade").toString()) > 0) {
                                jarray.set(elemento, objeto);
                                json.write(jarray.toString());
                                json.close();
                            } else {
                                jarray.remove(elemento);
                                json.write(jarray.toString());
                                json.close();
                                objeto.replace("quantidade", 0);
                                EscreverJSON escritor = new EscreverJSON("src" + File.separator + "Database"
                                        + File.separator + "Content" + File.separator + "fora_de_estoque.json", objeto);
                                escritor.escreverJson();
                            }

                        }

                    }

                }
                json.write(jarray.toString());
                json.close();
                return true;
            } else {
                return false;
            }
        } catch (IOException erro) {
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        } catch (ParseException erro) {
            System.out.println("Erro ao utilizar o parser");
        }
        return false;
    }

    public static JSONArray leProduto() {

        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";

        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = new JSONArray();
        jarray = leitor.getJarray();
        return jarray;

    }

    public static String[][] lerProdutosFiltrados(String database, String filtro) {
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = new JSONArray();
        jarray = leitor.getJarray();
        ArrayList<String[]> produtos = new ArrayList<String[]>();

        for (int i = 0; i < jarray.size(); i++) {
            JSONObject objeto = new JSONObject();
            JSONParser parser = new JSONParser();
            if(jarray.get(i).toString().contains(filtro)){
            try {
                objeto = (JSONObject) parser.parse(jarray.get(i).toString());
                String[] produto = new String[9];
                Object codigo = objeto.get("codigo");
                Object nome = objeto.get("nome");
                Object preco = objeto.get("preco");
                Object quantidade = objeto.get("quantidade");
                Object tamanho = objeto.get("tamanho");
                Object categorias = objeto.get("categorias");
                Object marca = objeto.get("marca");
                Object torra = objeto.get("torra");
                Object gourmet = objeto.get("gourmet");
                if (codigo != null) {
                    produto[0] = codigo.toString();
                } else {
                    produto[0] = " ";
                }
                if (nome != null) {
                    produto[1] = nome.toString();
                } else {
                    produto[1] = " ";
                }
                if (preco != null) {
                    produto[2] = preco.toString();
                } else {
                    produto[2] = " ";
                }
                if (categorias != null) {
                    produto[3] = categorias.toString();
                } else {
                    produto[3] = " ";
                }
                if (quantidade != null) {
                    produto[4] = quantidade.toString();
                } else {
                    produto[4] = " ";
                }
                if (tamanho != null) {
                    produto[5] = tamanho.toString();
                } else {
                    produto[5] = " ";
                }
                if (marca != null) {
                    produto[6] = marca.toString();
                } else {
                    produto[6] = " ";
                }
                if (torra != null) {
                    produto[7] = torra.toString();
                } else {
                    produto[7] = " ";
                }
                if (gourmet != null) {
                    produto[8] = gourmet.toString();
                } else {
                    produto[8] = " ";
                }
                produtos.add(produto);
            
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        }

        String[][] produtos_array = new String[produtos.size()][9];
        for (int i = 0; i < produtos.size(); i++) {
            produtos_array[i] = produtos.get(i);
        }

        return produtos_array;
    }

    public static String[][] lerTodosProdutos(String database) {
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = new JSONArray();
        jarray = leitor.getJarray();
        ArrayList<String[]> produtos = new ArrayList<String[]>();

        for (int i = 0; i < jarray.size(); i++) {
            JSONObject objeto = new JSONObject();
            JSONParser parser = new JSONParser();
            try {
                objeto = (JSONObject) parser.parse(jarray.get(i).toString());
                String[] produto = new String[9];
                Object codigo = objeto.get("codigo");
                Object nome = objeto.get("nome");
                Object preco = objeto.get("preco");
                Object quantidade = objeto.get("quantidade");
                Object tamanho = objeto.get("tamanho");
                Object categorias = objeto.get("categorias");
                Object marca = objeto.get("marca");
                Object torra = objeto.get("torra");
                Object gourmet = objeto.get("gourmet");
                if (codigo != null) {
                    produto[0] = codigo.toString();
                } else {
                    produto[0] = " ";
                }
                if (nome != null) {
                    produto[1] = nome.toString();
                } else {
                    produto[1] = " ";
                }
                if (preco != null) {
                    produto[2] = preco.toString();
                } else {
                    produto[2] = " ";
                }
                if (categorias != null) {
                    produto[3] = categorias.toString();
                } else {
                    produto[3] = " ";
                }
                if (quantidade != null) {
                    produto[4] = quantidade.toString();
                } else {
                    produto[4] = " ";
                }
                if (tamanho != null) {
                    produto[5] = tamanho.toString();
                } else {
                    produto[5] = " ";
                }
                if (marca != null) {
                    produto[6] = marca.toString();
                } else {
                    produto[6] = " ";
                }
                if (torra != null) {
                    produto[7] = torra.toString();
                } else {
                    produto[7] = " ";
                }
                if (gourmet != null) {
                    produto[8] = gourmet.toString();
                } else {
                    produto[8] = " ";
                }
                produtos.add(produto);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        String[][] produtos_array = new String[produtos.size()][9];
        for (int i = 0; i < produtos.size(); i++) {
            produtos_array[i] = produtos.get(i);
        }

        return produtos_array;
    }

    public static boolean excluiProduto(String codigo, String database) {
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = new JSONArray();
        jarray = leitor.getJarray();

        int len = jarray.size();
        JSONArray newJarray = new JSONArray();
        JSONObject objeto = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            for (int elemento = 0; elemento < len; elemento++) {
                objeto = (JSONObject) parser.parse(jarray.get(elemento).toString());
                if (objeto.containsValue(codigo) == false) {
                    newJarray.add(jarray.get(elemento));

                } else {
                    objeto.replace("quantidade", "excluido");
                    EscreverJSON escritor = new EscreverJSON("src" + File.separator + "Database" + File.separator
                            + "Content" + File.separator + "excluidos_do_estoque.json", objeto);
                    escritor.escreverJson();
                }
            }
            FileWriter json = new FileWriter(database);
            json.write(newJarray.toString());
            json.close();
            return true;
        } catch (IOException erro) {
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        } catch (ParseException erro) {
            System.out.println("Erro ao utilizar o parser");
        }
        return false;

    }

    public static boolean repoeNoEstoque(String codigo, Integer quantidade) {
        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "fora_de_estoque.json";
        String databaseEstoque = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = new JSONArray();
        jarray = leitor.getJarray();
        JSONArray jarrayEstoque = leProduto();
        int len = jarray.size();
        JSONObject objeto = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            if (quantidade > 0) {
                FileWriter json = new FileWriter(databaseEstoque);
                FileWriter jsonForaEstoque = new FileWriter(database);
                for (int elemento = 0; elemento < len; elemento++) {
                    objeto = (JSONObject) parser.parse(jarray.get(elemento).toString());
                    if (objeto.containsValue(codigo) == true) {
                        objeto.replace("quantidade", objeto.get("quantidade"),
                                Integer.parseInt(objeto.get("quantidade").toString()) + quantidade);
                        jarrayEstoque.add(objeto);
                        json.write(jarrayEstoque.toString());
                        json.close();
                        jarray.remove(elemento);
                        jsonForaEstoque.write(jarray.toString());
                        jsonForaEstoque.close();
                    }

                }
            } else {
                return false;
            }
            return true;
        } catch (IOException erro) {
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        } catch (ParseException erro) {
            System.out.println("Erro ao utilizar o parser");
        }
        return false;
    }

    public static boolean cadastraAperitivo(Aperitivo aperitivo) {

        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";

        try {
            if (aperitivo.getQuantidade() <= 0 || aperitivo.getPreco() < 0) {
                return false;
            } else {

                JSONObject objeto = new JSONObject();
                objeto.put("codigo", aperitivo.getCodigo());
                objeto.put("nome", aperitivo.getNome());
                objeto.put("preco", aperitivo.getPreco());
                objeto.put("quantidade", aperitivo.getQuantidade());
                objeto.put("categorias", aperitivo.getCategorias());
                objeto.put("tamanho", aperitivo.getTamanho());

                EscreverJSON escrever = new EscreverJSON(database, objeto);
                escrever.escreverJson();
            }

            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto");
            return false;
        }

    }

    public static boolean cadastraGrao(Grao grao) {

        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";

        try {
            if (grao.getQuantidade() <= 0 || grao.getPreco() < 0) {
                return false;
            } else {
                JSONObject objeto = new JSONObject();
                objeto.put("codigo", grao.getCodigo());
                objeto.put("nome", grao.getNome());
                objeto.put("preco", grao.getPreco());
                objeto.put("quantidade", grao.getQuantidade());
                objeto.put("categorias", grao.getCategorias());
                objeto.put("marca", grao.getMarca());
                objeto.put("gourmet", grao.getGourmet());
                objeto.put("torra", grao.getTorra());

                EscreverJSON escrever = new EscreverJSON(database, objeto);
                escrever.escreverJson();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto");
            return false;
        }

    }

    public static boolean cadastraBebida(Bebida bebida) {

        String database = "src" + File.separator + "Database" + File.separator + "Content" + File.separator
                + "estoque.json";

        try {
            if (bebida.getQuantidade() <= 0 || bebida.getPreco() < 0) {
                return false;
            } else {
                JSONObject objeto = new JSONObject();
                objeto.put("codigo", bebida.getCodigo());
                objeto.put("nome", bebida.getNome());
                objeto.put("preco", bebida.getPreco());
                objeto.put("quantidade", bebida.getQuantidade());
                objeto.put("categorias", bebida.getCategorias());

                EscreverJSON escrever = new EscreverJSON(database, objeto);
                escrever.escreverJson();
            }
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto");
            return false;
        }

    }
}
