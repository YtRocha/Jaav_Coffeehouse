package Models.Produtos;

public class Aperitivo extends Produto {

    // pequeno, medio, grande ou unico
    private String tamanho;

    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

}