package Utils.Txt;


import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EscreverArquivo {

    private String caminho;

    private String texto;


    public EscreverArquivo(String caminho, String texto) {
        this.caminho = caminho;
        this.texto = texto;
    }

    
    public boolean escreverArquivo(){
        try{
            FileWriter arquivo = new FileWriter(caminho, true);
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
