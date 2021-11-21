package Utils.JSON;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class EscreverJSON {
    
    private String caminho;

    private JSONObject objeto;


    public EscreverJSON(String caminho, JSONObject objeto) {
        this.caminho = caminho;
        this.objeto = objeto;
    }


    public boolean escreverJson(){

        try{
            FileWriter json = new FileWirter(caminho, true);
            json.write(objeto.toJSONString());
            json.close();
            return true;
        } catch(IOException erro){
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        }

    }




}
