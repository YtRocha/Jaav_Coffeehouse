package Models.Clientes;

public class Cliente {

    private String nome;

    private String cpf;

    /* ---- Construtor ---- */

    public Cliente() {

    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    /* ---- Getters e Setters ---- */


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
