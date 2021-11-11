package Utils.Txt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {
    private String caminho;
    private String conteudo;

    public LerArquivo() {
    }

    public LerArquivo(String caminho){
        this.caminho = caminho;
        this.conteudo = lerArquivo();
    }

    /*
        Ao utilizar o método, usar caminho relativo.
        Retorna string do conteúdo do arquivo de texto.
    */
    public String lerArquivo() {
        try {
            StringBuilder saida = new StringBuilder();
            BufferedReader buffered = new BufferedReader(new FileReader(caminho));

            try{
                String linha = buffered.readLine();

                while (linha != null) {
                    saida.append(linha + "\n");
                    linha = buffered.readLine();
                }
        
                buffered.close();
                return saida.toString();

            } catch (IOException err) {
                System.out.println("Erro ao ler arquivo.");
                return null;
            }

        } catch (FileNotFoundException err) {
            System.out.println("Arquivo não encontrado.");
            return null;
        } 
    }

    public String getConteudo(){
        return this.conteudo;
    }
}
