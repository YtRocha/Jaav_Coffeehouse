package Utils.Txt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EscreverArquivo {
    
    public static boolean escreverArquivo(String caminho, String texto){
        try{
            FileWriter arquivo = new FileWriter(caminho);
            PrintWriter escreverArquivo = new PrintWriter(arquivo);
            escreverArquivo.println(texto);
            escreverArquivo.close();
            return true;
        } catch(IOException erro){
            System.out.println("Erro ao escrever o arquivo.");
            System.out.println(erro.getMessage());
            return false;
        }
    }

}
