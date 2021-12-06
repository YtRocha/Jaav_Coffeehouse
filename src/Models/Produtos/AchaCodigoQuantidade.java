package Models.Produtos;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Utils.JSON.LerJSON;

public class AchaCodigoQuantidade {
    
    private String nome;

    private String database;

    private String codigo;
    
    private int quantidade;
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public AchaCodigoQuantidade(String nome, String database) {
        this.nome = nome;
        this.database = database;
    }
    
    
    public void acharCodigoQuantidade(){
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = leitor.getJarray();
        int len = jarray.size();
        JSONObject objeto = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            for (int elemento = 0; elemento < len; elemento++) {
                objeto = (JSONObject)parser.parse(jarray.get(elemento).toString());
                if(objeto.containsValue(nome.toLowerCase())){
                    this.codigo = objeto.get("codigo").toString();
                    this.quantidade = Integer.parseInt(objeto.get("quantidade").toString());
                    
                }
                
            }
        } catch (ParseException erro) {
            System.out.println("Erro ao utilizar o parser");
            
        }
    }

}



