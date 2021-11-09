package Models.Produtos;

public class Grao extends Produto{
    
    private String marca;

    private Boolean gourmet;

    private String  torra;


    public Grao(String marca, Boolean gourmet, String torra) {
        this.marca = marca;
        this.gourmet = gourmet;
        this.torra = torra;
    }


    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean isGourmet() {
        return this.gourmet;
    }

    public Boolean getGourmet() {
        return this.gourmet;
    }

    public void setGourmet(Boolean gourmet) {
        this.gourmet = gourmet;
    }

    public String getTorra() {
        return this.torra;
    }

    public void setTorra(String torra) {
        this.torra = torra;
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
