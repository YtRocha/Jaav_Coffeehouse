package Models.Produtos;

public class Bebida extends Produto{
    
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
