package Models.Produtos;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Utils.JSON.LerJSON;

public class ExisteCodigo {
    
    private Boolean existe;

    private String database;

    private String codigo;
    
    
    public Boolean getExiste(){
        return this.existe;
    }
    
    
    public ExisteCodigo(String codigo, String database) {
        this.codigo = codigo;
        this.database = database;
    }
    
    
    public void existeEsseCodigo(){
        LerJSON leitor = new LerJSON(database);
        leitor.lerJSON();
        JSONArray jarray = leitor.getJarray();
        int len = jarray.size();
        JSONObject objeto = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            for (int elemento = 0; elemento < len; elemento++) {
                objeto = (JSONObject)parser.parse(jarray.get(elemento).toString());
                if(objeto.containsValue(codigo.toUpperCase())){
                    this.existe = true;
                }
                
            }
        } catch (ParseException erro) {
            System.out.println("Erro ao utilizar o parser");
            
        }
    }

}



