package Utils.JSON;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LerJSON {

    private JSONArray jarray;

    private String caminho;

    private JSONParser parser = new JSONParser();

    public LerJSON(String caminho) {
        this.caminho = caminho;
    }

    public JSONArray getJarray() {
        return this.jarray;
    }

    public String lerJSON() {
        try {
            jarray = (JSONArray) parser.parse(new FileReader(caminho));
            return "Sucesso";
        } catch (FileNotFoundException error) {
            return "JSON não encontrado";
        } catch (IOException error) {
            return "Erro ao ler JSON";
        } catch (ParseException error) {
            return "Erro ao utilizar o parser";
        }
    }
}
