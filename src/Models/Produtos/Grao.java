package Models.Produtos;

public class Grao extends Produto{
    
    private String marca;

    private Boolean gourmet;

    private String  torra;


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


}