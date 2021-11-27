package Utils.JSON;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LerJSON {
    
    private JSONObject objeto;

    private String caminho;

    private JSONParser parser = new JSONParser();

    private String conteudo;


    public LerJSON(String caminho) {
        this.caminho = caminho;
    }

    public String getConteudo() {
        return this.conteudo;
    }


    public String lerJSON(){
        try{

            objeto = (JSONObject) = parser.parse(new FileReader(caminho));
            conteudo = objeto.toString();
            return conteudo;

        } catch(FileNotFoundException error){
            return "JSON não encontrado";
        } catch(IOException error){
            return"Erro ao ler JSON";
        } catch(ParseException error){
            return "Erro ao utilizar o parser";
        }
        

    }

}
