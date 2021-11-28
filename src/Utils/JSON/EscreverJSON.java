package Utils.JSON;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class EscreverJSON {
    
    private String caminho;

    private JSONObject objeto;
    
    public EscreverJSON(String caminho, JSONObject objeto) {
        this.caminho = caminho;
        this.objeto = objeto;
    }


    public boolean escreverJson(){

        try{
            LerJSON ler = new LerJSON(caminho);
            JSONArray jarray = new JSONArray();
            ler.lerJSON();
            jarray = ler.getJarray();
            jarray.add(objeto);
            FileWriter json = new FileWriter(caminho);
            json.write(jarray.toString());
            json.close();
            return true;
        } catch(IOException erro){
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        }

    }




}


