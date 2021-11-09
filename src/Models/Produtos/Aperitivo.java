package Models.Produtos;

public class Aperitivo extends Produto{

    //pequeno, medio, grande ou unico
    private String tamanho;

    public Aperitivo(String tamanho) {
        this.tamanho = tamanho;
    }


    public String getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }


    @Override
    public void retirarDoEstoque(int quantidade){
        if(this.getQuantidade() > 0){
            if((this.getQuantidade()-quantidade) < 0){

            }
            else
                this.setQuantidade(this.getQuantidade()-quantidade);
        }
    }

    @Override
    public void colocarNoEstoque(int quantidade){
        this.setQuantidade(this.getQuantidade()+quantidade);
    }

    
}
